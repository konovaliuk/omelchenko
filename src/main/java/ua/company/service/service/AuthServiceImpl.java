package ua.company.service.service;

import org.apache.log4j.Logger;
import ua.company.persistence.daofactory.DaoFactory;
import ua.company.persistence.domain.*;
import ua.company.persistence.idao.*;
import ua.company.service.logger.MyLogger;

import java.util.*;

/**
 * AuthServiceImpl.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class AuthServiceImpl implements AuthService {
    private static final Logger LOGGER = MyLogger.getLOGGER(AuthServiceImpl.class);
    private static final int ADMIN_TYPE_ID = 1;
    private static final int STUDENT_TYPE_ID = 2;
    private static final int RIGHT = 1;
    private static final int WRONG = 0;
    private static final int UKRAINIAN_ID = 1;
    private static final int ENGLISH_ID = 2;
    private static final String DEFAULT_SUBJECT_NAME = "All subjects";
    private static final Integer TIME_LIMIT = 5;
    private int maxTestNumber;
    private int testNumber;
    private int testId;
    private Test test;
    private List<QuestionTranslate> questionsTranslate;
    private List<Answer> answers;
    private List<AnswerTranslate> answersTranslate;
    private HashMap<QuestionTranslate, List<AnswerTranslate>> showQuiz;
    private HashMap<QuestionTranslate, List<Answer>> calculationResult;
    private List<QuestionTranslate> wrongAnswers;
    private boolean flagRightAnswer = false;
    private int countMistakes = 0;
    private int countQuestions = 0;
    private List<Result> results;
    private TreeMap<String, Double> resultByLogin;
    private int languageId;

    @Override
    public User registration(String login, String email, String password, String country, String gender) {
        IUser iUser = DaoFactory.getIUser();
        //IUserType iUserType = DaoFactory.getIUserType();
        //UserType userType = iUserType.getUserTypeById(STUDENT_TYPE_ID);
        User user = iUser.insertUser(login, email, password, country, gender, STUDENT_TYPE_ID);
        user.setAccess(true);
        return user;
    }

    @Override
    public User login(String login, String password) {
        IUser iUser = DaoFactory.getIUser();
        User user = iUser.getUserByLoginAndPass(login, password);
        user.setAccess(true);
        if (Objects.nonNull(user)) {
            return user;
        }
        return null;
    }

    @Override
    public boolean getAccess(String login, String password) {
        if (DaoFactory.getIUser().getUserByLoginAndPass(login, password) == null) {
            return false;
        }
        return true;
    }

    @Override
    public Test generateTest(Subject subject) {
        ITest iTest = DaoFactory.getITest();
        Random random = new Random();

        if (subject == null) {
            LOGGER.info("Subject is " + subject);
            maxTestNumber = iTest.getTestQuantity();
            testId = 1 + random.nextInt(maxTestNumber);
            test = iTest.getTestById(testId);
        } else {
            LOGGER.info("Subject is " + subject.getSubjectName());
            maxTestNumber = iTest.getTestQuantity(subject.getSubjectId());
            LOGGER.info("Number of available test of this subject: " + maxTestNumber);
            if (maxTestNumber == 0) {
                return null;
            }
            testNumber = random.nextInt(maxTestNumber);
            LOGGER.info("Number of test which was choosen: " + testNumber);
            test = iTest.getTestBySubjectId(subject.getSubjectId(), testNumber);
        }
        return test;
    }

    @Override
    public HashMap<QuestionTranslate, List<AnswerTranslate>> getQuestionAndAnswer(Test test, Locale locale) {

        ILanguage iLanguage = DaoFactory.getILanguage();
        ITestQuestion iTestQuestion = DaoFactory.getITestQuestion();

        LOGGER.info("Get id of Locale: " + String.valueOf(locale));
        languageId = iLanguage.getIdByName(String.valueOf(locale));
        LOGGER.info("LanguageId: " + languageId);
        LOGGER.info("Get questions from database by testId: " + test.getTestId());

        questionsTranslate = iTestQuestion.getQuestionByTestId(test.getTestId(), languageId);

        IAnswer iAnswer = DaoFactory.getIAnswer();
        IAnswerTranslate iAnswerTranslate = DaoFactory.getIAnswerTranslate();

//        calculationResult = new HashMap<>();
        showQuiz = new HashMap<>();
        for (QuestionTranslate questionTranslate : questionsTranslate) {
            answers = iAnswer.getAnswerByQuestionId(questionTranslate.getQuestionId());
            answersTranslate = iAnswerTranslate.getAnswerTranslateByAnswerIdAndLanguageId
                    (answers, languageId);

            showQuiz.put(questionTranslate, answersTranslate);
//            calculationResult.put(questionTranslate, answers);
        }
        return showQuiz;
    }

    @Override
    public List findWrongAnswers(HashMap<QuestionTranslate, List<AnswerTranslate>> showQuiz, String[] userAnswers) {
        IAnswer iAnswer = DaoFactory.getIAnswer();
        calculationResult = new HashMap<>();
        for (Map.Entry<QuestionTranslate, List<AnswerTranslate>> entry : showQuiz.entrySet()) {
            ArrayList<Answer> ans = new ArrayList();
            for (AnswerTranslate answerTranslate : entry.getValue()) {
                ans.add(iAnswer.getAnswerById(answerTranslate.getAnswerId()));
            }
            calculationResult.put(entry.getKey(), ans);
        }
        wrongAnswers = new ArrayList<>();

        LOGGER.info("Get answers from Loop for all questions");
        LOGGER.info("Loop for all questions");
        for (Map.Entry<QuestionTranslate, List<Answer>> entry : calculationResult.entrySet()) {
            countQuestions++;
            LOGGER.info("Loop for all answers");
            for (Answer answer : entry.getValue()) {
                if (answer.getIsRightAnswer() == RIGHT) {
                    flagRightAnswer = false;
                    for (String userAnswer : userAnswers) {
                        if (Integer.valueOf(userAnswer) == answer.getAnswerId()) {
                            flagRightAnswer = true;
                        }
                    }
                    if (!flagRightAnswer) {
                        countMistakes++;
                        wrongAnswers.add(entry.getKey());
                        break;
                    }
                }
            }
        }
        return wrongAnswers;
    }

    @Override
    public double getScore() {
        double result;
        result = ((double) countQuestions - (double) countMistakes) / (double) countQuestions * 100;
        return result;
    }

    @Override
    public void writeResult(User user, Test test, double score) {
        IResult iResult = DaoFactory.getIResult();
        iResult.insertResult(user, test, score);
    }

    @Override
    public boolean getUserTypeId(String login) {
        IUser iUser = DaoFactory.getIUser();
        return (iUser.getUserTypeIdByLogin(login) == ADMIN_TYPE_ID);
    }

    @Override
    public TreeMap getResults() {
        IResult iResult = DaoFactory.getIResult();
        results = iResult.getResults();
        resultByLogin = new TreeMap<>();
        for (Result result : results) {
            if (resultByLogin.containsKey(result.getLogin())) {
                double avScore = (result.getScore() + resultByLogin.get(result.getLogin())) / 2;
                resultByLogin.put(result.getLogin(), avScore);
            } else {
                resultByLogin.put(result.getLogin(), result.getScore());
            }
        }
        return resultByLogin;
    }

    @Override
    public Subject getSubject(int subjectId) {
        ISubject iSubject = DaoFactory.getISubject();
        return iSubject.getSubjectById(subjectId);
    }

    @Override
    public void writeTest(List<List<String>> questionsArr, List<String> subjectsArr, List<List<String>> answersEngArr,
                          List<List<String>> answersUkrArr, List<List<String>> isRightArr) {
        LOGGER.info("Writing to database new Test.");
        LOGGER.info("Loop for questions.");
        List<Integer> questionsId = new ArrayList<>();
        for (int i = 0; i < questionsArr.size(); i++) {
            int questionId = writeQuestion(subjectsArr.get(i));
            questionsId.add(questionId);
            LOGGER.info("Received questionId " + questionId);
            writeQuestionTranslate(questionId, questionsArr.get(i));
            List<Integer> answerId = writeAnswer(isRightArr.get(i), questionId);
            writeAnswerTranslate(answerId, answersEngArr.get(i), answersUkrArr.get(i));

        }
        int testId = writeNewTest("testname", subjectsArr);
        writeTestQuestion(testId, questionsId);
    }

    private int writeQuestion(String subjectName) {
        LOGGER.info("Write to question table.");
        ISubject iSubject = DaoFactory.getISubject();
        IQuestion iQuestion = DaoFactory.getIQuestion();
        return iQuestion.insertQuestion(iSubject.getSubjectIdByName(subjectName));
    }

    private void writeQuestionTranslate(int questionId, List<String> questions) {
        LOGGER.info("Write to questiontranslate table.");
        IQuestionTranslate iQuestionTranslate = DaoFactory.getIQuestionTranslate();
        for (int i = 0; i < questions.size(); i++) {
            iQuestionTranslate.insertQuestionTranslate(questionId, questions.get(i), i + 1);
        }
    }

    private List<Integer> writeAnswer(List<String> isRightAnswer, int questionId) {
        LOGGER.info("Write to answer table.");
        List<Integer> answerId = new ArrayList<>();
        IAnswer iAnswer = DaoFactory.getIAnswer();
        int statusAnswer;
        for (int i = 0; i < isRightAnswer.size(); i++) {
            if (isRightAnswer.get(i) == null) {
                statusAnswer = WRONG;
            } else {
                statusAnswer = RIGHT;
            }
            answerId.add(iAnswer.insertAnswer(statusAnswer, questionId));
        }
        return answerId;
    }

    private void writeAnswerTranslate(List<Integer> answerId, List<String> answersEngArr, List<String> answersUkrArr) {
        LOGGER.info("Write to answertranslate table.");
        IAnswerTranslate iAnswerTranslate = DaoFactory.getIAnswerTranslate();
        for (int i = 0; i < answerId.size(); i++) {
            iAnswerTranslate.insertQuestionTranslate(answerId.get(0), answersUkrArr.get(0), UKRAINIAN_ID);
            iAnswerTranslate.insertQuestionTranslate(answerId.get(0), answersEngArr.get(0), ENGLISH_ID);
        }
    }

    private int writeNewTest(String testName, List<String> subjectsArr) {
        LOGGER.info("Write to test table.");
        String subjectName="";
        for (int i = 0; i < subjectsArr.size() - 1; i++) {
            if (subjectsArr.get(i) != subjectsArr.get(i + 1)) {
                subjectName = DEFAULT_SUBJECT_NAME;
                break;
            }else{
                subjectName = subjectsArr.get(i);
            }
        }
        ISubject iSubject = DaoFactory.getISubject();
        ITest iTest = DaoFactory.getITest();
        return iTest.insertTest(testName, TIME_LIMIT, iSubject.getSubjectIdByName(subjectName));
    }

    private void writeTestQuestion(int testId, List<Integer> questionsId){
        LOGGER.info("Write to testquestion table.");
        ITestQuestion iTestQuestion = DaoFactory.getITestQuestion();
        for (int i=0; i<questionsId.size(); i++){
            iTestQuestion.insertTestQuestion(testId, questionsId.get(i));
        }
    }
}

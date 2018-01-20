package ua.company.service.service;

import org.apache.log4j.Logger;
import ua.company.persistence.daofactory.DaoFactory;
import ua.company.persistence.domain.*;
import ua.company.persistence.idao.*;
import ua.company.service.exception.NoSuchUserException;
import ua.company.service.logger.MyLogger;

import java.util.*;

/**
 * AuthServiceImpl.java - class of business logic. Connect dao layer and commands classes.
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

    /**
     * Pass to dao layer parameters of user for registration.
     * Set {@Link User#access} field to true.
     *
     * @param login      - login of user.
     * @param email      - email of user.
     * @param password   - password of user. Password must start of string, contain at least one digit, lower case and upper case letter, at \
     * least 8 symbols and no whitespace allowed.
     * @param country    - country of user inhabitance.
     * @param gender     - user gender.
     * @return inserted user in case of successful insertion and null vice versa
     */
    @Override
    public User registration(String login, String email, String password, String country, String gender) {
        IUser iUser = DaoFactory.getIUser();
        User user = iUser.insertUser(login, email, password, country, gender, STUDENT_TYPE_ID);
        if (user!=null){
            user.setAccess(true);
        }
        return user;
    }

    /**
     * Pass to dao layer parameters of user for login.
     * Set {@Link User#access} field to true.
     *
     * @param login login of user.
     * @param password password of user.
     * @throws NoSuchUserException if there is no such user in database
     * @return user in case of successful search
     */
    @Override
    public User login(String login, String password) throws NoSuchUserException {
        IUser iUser = DaoFactory.getIUser();
        User user = iUser.getUserByLoginAndPass(login, password);
        if (Objects.nonNull(user)) {
            user.setAccess(true);
            return user;
        } else {
            throw new NoSuchUserException("There is no such User in database");
        }
    }

    /**
     * Pass to dao layer parameters of user for login to check of presence this user in database.
     *
     * @param login login of user.
     * @param password password of user.
     * @return true if user with such login and password is registered and false vice versa
     */
    @Override
    public boolean getAccess(String login, String password) {
        if (DaoFactory.getIUser().getUserByLoginAndPass(login, password) == null) {
            return false;
        }
        return true;
    }

    /**
     * Generate by random id of quiz and pass to dao layer to find quiz in database
     *
     * @param subject - required subject of quiz.
     * @return created quiz in case of successful search and null vice versa
     */
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
            LOGGER.info("Number of test which was chosen: " + testNumber);
            test = iTest.getTestBySubjectId(subject.getSubjectId(), testNumber);
        }
        return test;
    }

    /**
     * Get questions and answers of given test taking into account required language
     *
     * @param test - required quiz.
     * @param locale - required language.
     * @return map of questions and answers for display to user
     */
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

        showQuiz = new HashMap<>();
        for (QuestionTranslate questionTranslate : questionsTranslate) {
            answers = iAnswer.getAnswerByQuestionId(questionTranslate.getQuestionId());
            answersTranslate = iAnswerTranslate.getAnswerTranslateByAnswerIdAndLanguageId
                    (answers, languageId);

            showQuiz.put(questionTranslate, answersTranslate);
        }
        return showQuiz;
    }

    /**
     * Identify wrong answers of user
     *
     * @param showQuiz - map of questions and answers
     * @param userAnswers - array of user answers for questions
     * @return list of wrong answers
     */
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

    /**
     * Calculate score of passed quiz
     *
     * @return results of passed quiz
     */
    @Override
    public double getScore() {
        double result;
        result = ((double) countQuestions - (double) countMistakes) / (double) countQuestions * 100;
        return result;
    }

    /**
     * Pass to dao layer results of tests for writing to database
     *
     * @param user - user who passed the quiz
     * @param test - passed quiz
     * @param score - result of passed quiz
     */
    @Override
    public void writeResult(User user, Test test, double score) {
        IResult iResult = DaoFactory.getIResult();
        iResult.insertResult(user, test, score);
    }

    /**
     * Pass to dao layer login of user to get his type and check if type is admin
     *
     * @param login - login of user
     * @return true if type is admin and false vice versa
     */
    @Override
    public boolean getUserTypeId(String login) {
        IUser iUser = DaoFactory.getIUser();
        return (iUser.getUserTypeIdByLogin(login) == ADMIN_TYPE_ID);
    }

    /**
     * Calculate average score of passed tests by students
     *
     * @return results of passed tests by students
     */
    @Override
    public TreeMap getResults() {
        double totalPoints;
        double avScore;
        int totalTestNumber;
        IResult iResult = DaoFactory.getIResult();
        results = iResult.getResults();
        resultByLogin = new TreeMap<>();
        for (Result result : results) {
            if (!resultByLogin.containsKey(result.getLogin())) {
            String student = result.getLogin();
            totalPoints = 0;
            totalTestNumber = 0;
            for (Result resultStudent : results) {
                if (student.equals(resultStudent.getLogin())){
                    totalPoints = totalPoints + resultStudent.getScore();
                    totalTestNumber++;
                }
            }
            avScore = Math.round(totalPoints / (double)totalTestNumber);
            resultByLogin.put(result.getLogin(), avScore);
            }
        }
        return resultByLogin;
    }

    /**
     * Pass to dao layer subject Id in order to get Subject entity
     *
     * @param subjectId - subject Id
     * @return subject
     */
    @Override
    public Subject getSubject(int subjectId) {
        ISubject iSubject = DaoFactory.getISubject();
        return iSubject.getSubjectById(subjectId);
    }

    /**
     * Process writing to database new test
     *
     * @param questionsArr - list of questions
     * @param subjectsArr - list of subjects
     * @param answersEngArr - list of answers in English
     * @param answersUkrArr - list of answers in Ukrainian
     * @param isRightArr - list of sign which answer is right
     */
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

    /**
     * Process writing to database new question
     *
     * @param subjectName - name of subject
     * @return Id of inserted question in case of successful insertion and 0 vice versa
     */
    private int writeQuestion(String subjectName) {
        LOGGER.info("Write to question table.");
        ISubject iSubject = DaoFactory.getISubject();
        IQuestion iQuestion = DaoFactory.getIQuestion();
        return iQuestion.insertQuestion(iSubject.getSubjectIdByName(subjectName));
    }

    /**
     * Process writing to database new question in different languages
     *
     * @param questionId - question Id
     * @param questions - questions which will be written
     */
    private void writeQuestionTranslate(int questionId, List<String> questions) {
        LOGGER.info("Write to questiontranslate table.");
        IQuestionTranslate iQuestionTranslate = DaoFactory.getIQuestionTranslate();
        for (int i = 0; i < questions.size(); i++) {
            iQuestionTranslate.insertQuestionTranslate(questionId, questions.get(i), i + 1);
        }
    }

    /**
     * Process writing to database new answers
     *
     * @param isRightAnswer - sign whether the answer is right
     * @param questionId - question Id
     * @return list of answers Id
     */
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

    /**
     * Process writing to database new answers in different languages
     *
     * @param answerId - answer Id
     * @param answersEngArr - list of answers in English
     * @param answersUkrArr - list of answers in Ukrainian
     */
    private void writeAnswerTranslate(List<Integer> answerId, List<String> answersEngArr, List<String> answersUkrArr) {
        LOGGER.info("Write to answertranslate table.");
        IAnswerTranslate iAnswerTranslate = DaoFactory.getIAnswerTranslate();
        for (int i = 0; i < answerId.size(); i++) {
            iAnswerTranslate.insertAnswerTranslate(answerId.get(0), answersUkrArr.get(0), UKRAINIAN_ID);
            iAnswerTranslate.insertAnswerTranslate(answerId.get(0), answersEngArr.get(0), ENGLISH_ID);
        }
    }

    /**
     * Process writing to database new test
     *
     * @param testName - name of test
     * @param subjectsArr - list of tests subjects
     * @return Id of test if test was inserted and 0 vice versa
     */
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

    /**
     * Process writing to database questions of new test
     *
     * @param testId - test Id
     * @param questionsId - questions Id
     */
    private void writeTestQuestion(int testId, List<Integer> questionsId){
        LOGGER.info("Write to testquestion table.");
        ITestQuestion iTestQuestion = DaoFactory.getITestQuestion();
        for (int i=0; i<questionsId.size(); i++){
            iTestQuestion.insertTestQuestion(testId, questionsId.get(i));
        }
    }
}

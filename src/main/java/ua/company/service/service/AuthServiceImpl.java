package ua.company.service.service;

import org.apache.log4j.Logger;
import ua.company.persistence.dao.ResultDao;
import ua.company.persistence.dao.UserDao;
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
    private int maxTestNumber;
    private int testId;
    private Test test;
    private List<QuestionTranslate> questionsTranslate;
    private List<Answer> answers;
    private List<AnswerTranslate> answersTranslate;
    private HashMap<QuestionTranslate, List<AnswerTranslate>> showQuiz;
    private HashMap<QuestionTranslate, List<Answer>> calculationResult;
    private List<QuestionTranslate> wrongAnswers;
    private List<QuestionTranslate> wrongQuestion;
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
    public Test generateTest() {
        ITest iTest = DaoFactory.getITest();
        maxTestNumber = iTest.getTestQuantity();
        Random random = new Random();
        testId = 1 + random.nextInt(maxTestNumber);
        test = iTest.getTestById(testId);
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
        for (Map.Entry<QuestionTranslate, List<AnswerTranslate>> entry : showQuiz.entrySet()){
            ArrayList <Answer> ans = new ArrayList();
            for (AnswerTranslate answerTranslate: entry.getValue()) {
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
        IUser iUser = new UserDao();
        return (iUser.getUserTypeIdByLogin(login) == ADMIN_TYPE_ID);
    }

    @Override
    public TreeMap getResults() {
        IResult iResult = new ResultDao();
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
}

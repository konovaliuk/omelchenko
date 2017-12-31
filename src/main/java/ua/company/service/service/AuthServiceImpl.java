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
    private static final int RIGHT = 1;
    private static final int STUDENT_TYPE_ID = 2;
    private int maxTestNumber;
    private int testId;
    private Test test;
    private List<Question> questions;
    private List<Answer> answers;
    private HashMap<Question, List<Answer>> quiz;
    private List<Question> wrongAnswers;
    private boolean flagRightAnswer=false;
    private int countMistakes=0;
    private int countQuestions = 0;

    @Override
    public User registration(String login, String email, String password, String country, String gender) {
        IUser iUser = DaoFactory.getIUser();
        IUserType iUserType = DaoFactory.getIUserType();
        UserType userType = iUserType.getUserTypeById(STUDENT_TYPE_ID);
        User user = iUser.insertUser(login, email, password, country, gender, userType);
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
    public HashMap<Question, List<Answer>> getQuestionAndAnswer(Test test) {
        ITestQuestion iTestQuestion = DaoFactory.getITestQuestion();
        questions = iTestQuestion.getQuestionByTestId(test.getTestId());
        IAnswer iAnswer = DaoFactory.getIAnswer();
        quiz = new HashMap<>();
        for (Question question : questions) {
            answers = iAnswer.getAnswerByQuestionId(question.getQuestionId());
            quiz.put(question, answers);
        }
        return quiz;
    }

    @Override
    public List findWrongAnswers(HashMap<Question, List<Answer>> quiz, String[] userAnswers) {
        wrongAnswers = new ArrayList<>();
        LOGGER.info("Loop for all questions");
        for (Map.Entry<Question, List<Answer>> entry : quiz.entrySet()) {
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
                    if (!flagRightAnswer){
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
        result = ((double)countQuestions-(double)countMistakes)/(double)countQuestions*100;
        return result;
    }

    @Override
    public void writeResult(User user, Test test, double score) {

    }
}

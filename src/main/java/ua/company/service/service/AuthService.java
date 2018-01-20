package ua.company.service.service;

import ua.company.persistence.domain.*;
import ua.company.service.exception.NoSuchUserException;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/**
 * AuthService.java - interface which is implemented by class AuthServiceImpl
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public interface AuthService {

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
    User registration(String login, String email, String password, String country, String gender);

    /**
     * Pass to dao layer parameters of user for login.
     * Set {@Link User#access} field to true.
     *
     * @param login login of user.
     * @param password password of user.
     * @throws NoSuchUserException if there is no such user in database
     * @return user in case of successful search
     */
    User login(String login, String password) throws NoSuchUserException;

    /**
     * Pass to dao layer parameters of user for login to check of presence this user in database.
     *
     * @param login login of user.
     * @param password password of user.
     * @return true if user with such login and password is registered and false vice versa
     */
    boolean getAccess(String login, String password);

    /**
     * Generate by random id of quiz and pass to dao layer to find quiz in database
     *
     * @param subject - required subject of quiz.
     * @return created quiz in case of successful search and null vice versa
     */
    Test generateTest(Subject subject);

    /**
     * Get questions and answers of given test taking into account required language
     *
     * @param test - required quiz.
     * @param locale - required language.
     * @return map of questions and answers for display to user
     */
    HashMap<QuestionTranslate,List<AnswerTranslate>> getQuestionAndAnswer(Test test, Locale locale);

    /**
     * Identify wrong answers of user
     *
     * @param showQuiz - map of questions and answers
     * @param userAnswers - array of user answers for questions
     * @return list of wrong answers
     */
    List findWrongAnswers(HashMap<QuestionTranslate, List<AnswerTranslate>> showQuiz, String[] userAnswers);

    /**
     * Calculate score of passed quiz
     *
     * @return results of passed quiz
     */
    double getScore();

    /**
     * Pass to dao layer results of tests for writing to database
     *
     * @param user - user who passed the quiz
     * @param test - passed quiz
     * @param score - result of passed quiz
     */
    void writeResult(User user, Test test, double score);

    /**
     * Pass to dao layer login of user to get his type and check if type is admin
     *
     * @param login - login of user
     * @return true if type is admin and false vice versa
     */
    boolean getUserTypeId(String login);

    /**
     * Calculate average score of passed tests by students
     *
     * @return results of passed tests by students
     */
    TreeMap getResults();

    /**
     * Pass to dao layer subject Id in order to get Subject entity
     *
     * @param subjectId - subject Id
     * @return subject
     */
    Subject getSubject(int subjectId);

    /**
     * Process writing to database new test
     *
     * @param questionsArr - list of questions
     * @param subjectsArr - list of subjects
     * @param answersEngArr - list of answers in English
     * @param answersUkrArr - list of answers in Ukrainian
     * @param isRightArr - list of sign which answer is right
     */
    void writeTest (List<List<String>> questionsArr, List<String> subjectsArr, List<List<String>> answersEngArr,
                    List<List<String>> answersUkrArr, List<List<String>> isRightArr);
}

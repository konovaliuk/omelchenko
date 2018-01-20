package ua.company.persistence.daofactory;

import ua.company.persistence.dao.*;
import ua.company.persistence.idao.*;

/**
 * DaoFactory.java - factory which provide functionality for creating different DAO classes
 * for processing requests to database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 28 Dec 2017
 */
public class DaoFactory {

    /**
     * Create new object of {@link UserDao} class.
     *
     * @return created object of class {@link UserDao}
     */
    public static IUser getIUser() {
        return new UserDao();
    }

    /**
     * Create new object of {@link UserTypeDao} class.
     *
     * @return created object of class {@link UserTypeDao}
     */
    public static IUserType getIUserType() {
        return new UserTypeDao();
    }

    /**
     * Create new object of {@link TestDao} class.
     *
     * @return created object of class {@link TestDao}
     */
    public static ITest getITest() {
        return new TestDao();
    }

    /**
     * Create new object of {@link QuestionDao} class.
     *
     * @return created object of class {@link QuestionDao}
     */
    public static IQuestion getIQuestion() {
        return new QuestionDao();
    }

    /**
     * Create new object of {@link TestQuestionDao} class.
     *
     * @return created object of class {@link TestQuestionDao}
     */
    public static ITestQuestion getITestQuestion() {
        return new TestQuestionDao();
    }

    /**
     * Create new object of {@link AnswerDao} class.
     *
     * @return created object of class {@link AnswerDao}
     */
    public static IAnswer getIAnswer() {
        return new AnswerDao();
    }

    /**
     * Create new object of {@link LanguageDao} class.
     *
     * @return created object of class {@link LanguageDao}
     */
    public static ILanguage getILanguage() {
        return new LanguageDao();
    }

    /**
     * Create new object of {@link ResultDao} class.
     *
     * @return created object of class {@link ResultDao}
     */
    public static IResult getIResult() {
        return new ResultDao();
    }

    /**
     * Create new object of {@link SubjectDao} class.
     *
     * @return created object of class {@link SubjectDao}
     */
    public static ISubject getISubject() {
        return new SubjectDao();
    }

    /**
     * Create new object of {@link QuestionTranslateDao} class.
     *
     * @return created object of class {@link QuestionTranslateDao}
     */
    public static IQuestionTranslate getIQuestionTranslate() {
        return new QuestionTranslateDao();
    }

    /**
     * Create new object of {@link AnswerTranslateDao} class.
     *
     * @return created object of class {@link AnswerTranslateDao}
     */
    public static IAnswerTranslate getIAnswerTranslate() {
        return new AnswerTranslateDao();
    }
}

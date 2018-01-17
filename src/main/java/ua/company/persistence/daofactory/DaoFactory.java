package ua.company.persistence.daofactory;

import ua.company.persistence.dao.*;
import ua.company.persistence.idao.*;

/**
 * DaoFactory.java - factory which provide functionality for creating different DAO.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 28 Dec 2017
 */
public class DaoFactory {

   public static IUser getIUser() {
       return new UserDao();
    }

    public static IUserType getIUserType() {
        return new UserTypeDao();
    }

    public static ITest getITest() {
        return new TestDao();
    }

    public static IQuestion getIQuestion() {
        return new QuestionDao();
    }

    public static ITestQuestion getITestQuestion() {
        return new TestQuestionDao();
    }

    public static IAnswer getIAnswer() {
        return new AnswerDao();
    }

    public static ILanguage getILanguage() {
        return new LanguageDao();
    }

    public static IResult getIResult() {
        return new ResultDao();
    }

    public static ISubject getISubject() {
        return new SubjectDao();
    }

    public static IQuestionTranslate getIQuestionTranslate() {
        return new QuestionTranslateDao();
    }

    public static IAnswerTranslate getIAnswerTranslate() {
        return new AnswerTranslateDao();
    }
}

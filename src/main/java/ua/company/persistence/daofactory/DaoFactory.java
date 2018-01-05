package ua.company.persistence.daofactory;

import ua.company.persistence.dao.*;
import ua.company.persistence.datasource.ConnectionWithoutPool;
import ua.company.persistence.idao.*;

/**
 * DaoFactory.java - factory which provide functionality for creating different DAO.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 28 Dec 2017
 */
public class DaoFactory {

   public static IUser getIUser() {

//       ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
//       return new UserDao(connectionPool.getConnection());
       return new UserDao();
    }

    public static IUserType getIUserType() {
//        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
//        return new UserTypeDao(connectionPool.getConnection());
        return new UserTypeDao(new ConnectionWithoutPool().connect_to_database());
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

//    public static void closeConnection(Connection connection){
//        new ConnectionWithoutPool().close(connection);
//    }

}

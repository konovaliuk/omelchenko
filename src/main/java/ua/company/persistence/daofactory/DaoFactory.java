package ua.company.persistence.daofactory;

import ua.company.persistence.dao.*;
import ua.company.persistence.datasource.ConnectionPool;
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
       return new UserDao(new ConnectionWithoutPool().connect_to_database());
    }

    public static IUserType getIUserType() {
//        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
//        return new UserTypeDao(connectionPool.getConnection());
        return new UserTypeDao(new ConnectionWithoutPool().connect_to_database());
    }

    public static IAnswer getIAnswer() {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        return new AnswerDao(connectionPool.getConnection());
    }

    public static ILanguage getILanguage() {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        return new LanguageDao(connectionPool.getConnection());
    }

    public static IQuestion getIQuestion() {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        return new QuestionDao(connectionPool.getConnection());
    }

    public static IResult getIResult() {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        return new ResultDao(connectionPool.getConnection());
    }

    public static ITest getITest() {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        return new TestDao(connectionPool.getConnection());
    }

    public static ITestQuestion getITestQuestion() {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        return new TestQuestionDao(connectionPool.getConnection());
    }

    public static ISubject getITopic() {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        return new SubjectDao(connectionPool.getConnection());
    }

//    public static void closeConnection(Connection connection){
//        new ConnectionWithoutPool().close(connection);
//    }

}

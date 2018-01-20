package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.daofactory.DaoFactory;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.Result;
import ua.company.persistence.domain.Test;
import ua.company.persistence.domain.User;
import ua.company.persistence.idao.IResult;
import ua.company.persistence.idao.ISubject;
import ua.company.service.logger.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ResultDao.java - process requests to table result in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class ResultDao implements IResult {
    private static final Logger LOGGER = MyLogger.getLOGGER(ResultDao.class);
    private static final String NAME_TABLE = "result";
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (login,"
            + " testName,"
            + " subjectName,"
            + " score)"
            + " VALUES (?, ?, ?, ?)";
    private static final String FIND_RESULT = "SELECT * FROM " + NAME_TABLE;
    private String subjectName;
    private List<Result> results;

    /**
     * Insert results of passed quiz.
     *
     * @param user user who finished test
     * @param test test which was passed
     * @param score score of passed test
     * @return true in case of successful insertion and false vice versa
     */
    @Override
    public boolean insertResult(User user, Test test, double score) {
        ISubject iSubject = DaoFactory.getISubject();
        subjectName = iSubject.getSubjectNameById(test.getSubjectId());
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, test.getTestName());
            preparedStatement.setString(3, subjectName);
            preparedStatement.setDouble(4, score);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Results was not inserted in database: ", e);
        } finally {
            connectionPool.close();
        }
        return false;
    }

    /**
     * Get results by Students.
     *
     * @return list of results by students in case of successful request and null vice versa
     */
    @Override
    public List<Result> getResults() {
        results = new ArrayList<>();

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_RESULT);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                Result result = new Result();
                result.setId(rs.getInt(1));
                result.setLogin(rs.getString(2));
                result.setTestName(rs.getString(3));
                result.setSubjectName(rs.getString(4));
                result.setScore(rs.getInt(5));
                results.add(result);
            }
            return results;

        } catch (SQLException e) {
            LOGGER.error("Can not get result from database: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }
}

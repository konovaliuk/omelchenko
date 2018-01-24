package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.Test;
import ua.company.persistence.idao.ITest;
import ua.company.service.logger.MyLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TestDao.java - process requests to table test in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class TestDao implements ITest {
    private static final Logger LOGGER = MyLogger.getLOGGER(TestDao.class);
    private static final String NAME_TABLE = "test";
    private static final String COUNT_ROWS_OF_SUBJECT = "SELECT COUNT(*) FROM " + NAME_TABLE +
            " WHERE subjectId=?";
    private static final String COUNT_ROWS = "SELECT COUNT(*) FROM " + NAME_TABLE;
    private static final String FIND_BY_ID = "SELECT * FROM " + NAME_TABLE +
            " WHERE testId=?";
    private static final String FIND_BY_SUBJECTID = "SELECT * FROM " + NAME_TABLE +
            " WHERE subjectId=?";
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (testName,"
            + " timeLimit,"
            + " subjectId)"
            + " VALUES (?, ?, ?)";
    private int countRaws;
    private List<Test> tests;

    /**
     * Find test in database by test Id.
     *
     * @param testId Id of test
     * @return test in case of successful search and null vice versa
     */
    @Override
    public Test getTestById(int testId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, testId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Test test = new Test();
                    test.setTestId(rs.getInt(1));
                    test.setTestName(rs.getString(2));
                    test.setTimeLimit(rs.getInt(3));
                    test.setSubjectId(rs.getInt(4));
                    return test;
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Can not get test by Id from database: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }

    /**
     * Find list of tests in database of requested subject Id and return one test according
     * to requested position of test in the list.
     *
     * @param subjectId Id of subject
     * @param testNumber position of test in the tests list
     * @return test in case of successful search and null vice versa
     */
    @Override
    public Test getTestBySubjectId(int subjectId, int testNumber) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        tests = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_SUBJECTID)) {
            preparedStatement.setInt(1, subjectId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Test test = new Test();
                    test.setTestId(rs.getInt(1));
                    test.setTestName(rs.getString(2));
                    test.setTimeLimit(rs.getInt(3));
                    test.setSubjectId(rs.getInt(4));
                    tests.add(test);
                }
                return tests.get(testNumber);
            }
        } catch (SQLException e) {
            LOGGER.error("Can not get test by subjectId from database: ", e);
        } finally {
            connectionPool.close();
        }
        return null;

    }

    /**
     * Get quantity of tests in database
     *
     * @return quantity of test in database
     */
    @Override
    public int getTestQuantity() {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ROWS);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                countRaws = rs.getInt(1);
            }
            return countRaws;
        } catch (SQLException e) {
            LOGGER.error("Can not get tests' quantity from table test: ", e);
        } finally {
            connectionPool.close();
        }
        return 0;
    }

    /**
     * Get quantity of tests in database of requested subject
     *
     * @param subjectId Id of subject
     * @return quantity of test in database of required subject
     */
    @Override
    public int getTestQuantity(int subjectId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ROWS_OF_SUBJECT)) {
            preparedStatement.setInt(1, subjectId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    countRaws = rs.getInt(1);
                }
                return countRaws;
            }
        } catch (SQLException e) {
            LOGGER.error("Can not get tests' quantity with defined subjectId from table test: ", e);
        } finally {
            connectionPool.close();
        }
        return 0;
    }

    /**
     * Insert test in table test.
     *
     * @param testName the name of test
     * @param timeLimit the time for deciding test
     * @param subjectId Id of subject
     * @param connection connection with database
     * @throws SQLException - if exception deal with database is occurred
     * @return Id of test if test was inserted and 0 vice versa
     */
    @Override
    public int insertTest(String testName, int timeLimit, int subjectId, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT,
                Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, testName);
            preparedStatement.setInt(2, timeLimit);
            preparedStatement.setInt(3, subjectId);
            preparedStatement.executeUpdate();
            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }
}

package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.Test;
import ua.company.persistence.idao.ITest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TestDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class TestDao implements ITest {
    private static final String NAME_TABLE = "test";
    private static final String COUNT_ROWS_OF_SUBJECT = "SELECT COUNT(*) FROM " + NAME_TABLE+
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

    @Override
    public Test getTestById(int testId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)){
            preparedStatement.setInt(1, testId);
            try(ResultSet rs = preparedStatement.executeQuery()) {
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
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
   return null;
    }

    @Override
    public Test getTestBySubjectId(int subjectId, int testNumber) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tests = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_SUBJECTID)){
            preparedStatement.setInt(1, subjectId);
            try(ResultSet rs = preparedStatement.executeQuery()) {
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
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return null;

    }

    @Override
    public int getTestQuantity() {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ROWS);
            ResultSet rs = preparedStatement.executeQuery())
        {
            while(rs.next()){
                countRaws = rs.getInt(1);
            }
        return countRaws;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
    return 0;
    }

    @Override
    public int getTestQuantity(int subjectId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ROWS_OF_SUBJECT)){
            preparedStatement.setInt(1, subjectId);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    countRaws = rs.getInt(1);
                }
                return countRaws;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return 0;
    }

    @Override
    public int insertTest(String testName, int timeLimit, int subjectId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, testName);
            preparedStatement.setInt(2, timeLimit);
            preparedStatement.setInt(3, subjectId);
            preparedStatement.executeUpdate();
            try(ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return 0;
    }
}

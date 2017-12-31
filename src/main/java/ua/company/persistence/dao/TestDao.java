package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionWithoutPool;
import ua.company.persistence.domain.Test;
import ua.company.persistence.idao.ITest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TestDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class TestDao implements ITest {
    private static final String NAME_TABLE = "test";
    private static final String COUNT_ROWS = "SELECT COUNT(*) FROM " + NAME_TABLE;
    private static final String FIND_BY_ID = "SELECT * FROM " + NAME_TABLE +
            " WHERE testId=?";
    private int countRaws;

//    private Connection connection = null;
//
//    public TestDao(Connection connection){
//        this.connection=connection;
//    }

    @Override
    public Test getTestById(int testId) {
        ConnectionWithoutPool connectionWithoutPool = new ConnectionWithoutPool();
        Connection connection = connectionWithoutPool.connect_to_database();
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID))
        {
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
            connectionWithoutPool.close(connection);
        }
   return null;
    }

    public int getTestQuantity() {
        ConnectionWithoutPool connectionWithoutPool = new ConnectionWithoutPool();
        Connection connection = connectionWithoutPool.connect_to_database();
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
            connectionWithoutPool.close(connection);
        }
    return 0;
    }
}

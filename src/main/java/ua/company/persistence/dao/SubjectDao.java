package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.Subject;
import ua.company.persistence.idao.ISubject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TopicDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class SubjectDao implements ISubject {
    private static final String NAME_TABLE = "subject";
    private static final String FIND_NAME_BY_ID = "SELECT * FROM " + NAME_TABLE +
            " WHERE subjectId=?";
    private static final String FIND_ID_BY_NAME = "SELECT * FROM " + NAME_TABLE +
            " WHERE subjectName=?";

    @Override
    public String getSubjectNameById(int subjectId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_NAME_BY_ID)) {
            preparedStatement.setInt(1, subjectId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    String subjectName = rs.getString(2);
                    return subjectName;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
            return null;
    }

    @Override
    public Subject getSubjectById(int subjectId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_NAME_BY_ID)) {
            preparedStatement.setInt(1, subjectId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    Subject subject = new Subject();
                    subject.setSubjectId(rs.getInt(1));
                    subject.setSubjectName(rs.getString(2));
                    return subject;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return null;
    }

    @Override
    public int getSubjectIdByName(String subjectName) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_BY_NAME)) {
            preparedStatement.setString(1, subjectName);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return 0;
    }
}

package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.Subject;
import ua.company.persistence.idao.ISubject;
import ua.company.service.logger.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * SubjectDao.java - process requests to table subject in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class SubjectDao implements ISubject {
    private static final Logger LOGGER = MyLogger.getLOGGER(SubjectDao.class);
    private static final String NAME_TABLE = "subject";
    private static final String FIND_NAME_BY_ID = "SELECT * FROM " + NAME_TABLE +
            " WHERE subjectId=?";
    private static final String FIND_ID_BY_NAME = "SELECT * FROM " + NAME_TABLE +
            " WHERE subjectName=?";

    /**
     * Find subject name in database by subject Id.
     *
     * @param subjectId Id of subject
     * @return subject name in case of successful search and null vice versa
     */
    @Override
    public String getSubjectNameById(int subjectId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
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
            LOGGER.error("Can not get subject name by subjectId from database: ", e);
        } finally {
            connectionPool.close();
        }
            return null;
    }

    /**
     * Find subject in database by subject Id.
     *
     * @param subjectId Id of subject
     * @return subject in case of successful search and null vice versa
     */
    @Override
    public Subject getSubjectById(int subjectId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
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
            LOGGER.error("Can not get subject by subjectId from database: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }

    /**
     * Find subject Id in database by requested subject name.
     *
     * @param subjectName name of requested subject
     * @return subjectId in case of successful search and 0 vice versa
     */
    @Override
    public int getSubjectIdByName(String subjectName) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_BY_NAME)) {
            preparedStatement.setString(1, subjectName);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }catch (SQLException e) {
            LOGGER.error("Can not get subjectId by name from database: ", e);
        } finally {
            connectionPool.close();
        }
        return 0;
    }
}

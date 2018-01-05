package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionWithoutPool;
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


    @Override
    public String getSubjectNameById(int subjectId) {
        ConnectionWithoutPool connectionWithoutPool = new ConnectionWithoutPool();
        Connection connection = connectionWithoutPool.connect_to_database();

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
                connectionWithoutPool.close(connection);
        }
            return null;
    }
}

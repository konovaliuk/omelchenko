package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.QuestionTranslate;
import ua.company.persistence.idao.IQuestionTranslate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * QuestionTranslateDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public class QuestionTranslateDao implements IQuestionTranslate {
    private static final String NAME_TABLE = "questiontranslate";
    private static final String FIND_BY_QUESTIONID_AND_LANGUAGEID = "SELECT * FROM " + NAME_TABLE +
            " WHERE questionId=? AND languageId=?";
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (questionId,"
            + " questionText,"
            + " languageId)"
            + " VALUES (?, ?, ?)";

    @Override
    public QuestionTranslate getQuestionTranslateByQuestionIdAndLanguageId(int questionId, int languageId) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_QUESTIONID_AND_LANGUAGEID)) {
            preparedStatement.setInt(1, questionId);
            preparedStatement.setInt(2, languageId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    QuestionTranslate questionTranslate = new QuestionTranslate();
                    questionTranslate.setQuestiontranslateId(rs.getInt(1));
                    questionTranslate.setQuestionId (rs.getInt(2));
                    questionTranslate.setQuestionText(rs.getString(3));
                    questionTranslate.setLanguageId(rs.getInt(4));
                    return questionTranslate;
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
    public boolean insertQuestionTranslate(int questionId, String questionText, int languageId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, questionId);
            preparedStatement.setString(2, questionText);
            preparedStatement.setInt(3, languageId);
            preparedStatement.executeUpdate();
            try(ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return false;
    }
}

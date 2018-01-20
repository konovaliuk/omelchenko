package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.QuestionTranslate;
import ua.company.persistence.idao.IQuestionTranslate;
import ua.company.service.logger.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * QuestionTranslateDao.java - process requests to table questiontranslate in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public class QuestionTranslateDao implements IQuestionTranslate {

    /**
     * Field class {@Link MyLogger}
     */
    private static final Logger LOGGER = MyLogger.getLOGGER(QuestionTranslateDao.class);
    /**
     * Field name of table
     */
    private static final String NAME_TABLE = "questiontranslate";
    /**
     * SQL query to find question by Id and language Id
     */
    private static final String FIND_BY_QUESTIONID_AND_LANGUAGEID = "SELECT * FROM " + NAME_TABLE +
            " WHERE questionId=? AND languageId=?";
    /**
     * SQL query to insert question in table
     */
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (questionId,"
            + " questionText,"
            + " languageId)"
            + " VALUES (?, ?, ?)";

    /**
     * Find question in database by question Id and required language.
     *
     * @param questionId list of answers
     * @param languageId Id of language
     * @return question of required language in case of successful search and null vice versa
     */
    @Override
    public QuestionTranslate getQuestionTranslateByQuestionIdAndLanguageId(int questionId, int languageId) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
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
            LOGGER.error("Can not get question by questionId and languageId from database: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }

    /**
     * Insert question in table questiontranslate.
     *
     * @param questionId Id of question which is inserted
     * @param questionText text of question
     * @param languageId Id of language
     * @return true if question was inserted and false vice versa
     */
    @Override
    public boolean insertQuestionTranslate(int questionId, String questionText, int languageId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
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
            LOGGER.error("Question was not inserted in table questiontranslate: ", e);
        } finally {
            connectionPool.close();
        }
        return false;
    }
}

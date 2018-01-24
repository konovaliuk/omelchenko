package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.Answer;
import ua.company.persistence.domain.AnswerTranslate;
import ua.company.persistence.idao.IAnswerTranslate;
import ua.company.service.logger.MyLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AnswerTranslateDao.java - process requests to table answertranslate in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public class AnswerTranslateDao implements IAnswerTranslate {

    /**
     * Field class {@Link MyLogger}
     */
    private static final Logger LOGGER = MyLogger.getLOGGER(AnswerTranslateDao.class);
    /**
     * Field name of table
     */
    private static final String NAME_TABLE = "answerTranslate";
    /**
     * SQL query to find answer by Id and language Id
     */
    private static final String FIND_BY_ANSWERID = "SELECT * FROM " + NAME_TABLE +
            " WHERE answerId=? AND languageId=?";
    /**
     * SQL query to insert answer in table
     */
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (answerId,"
            + " answerText,"
            + " languageId)"
            + " VALUES (?, ?, ?)";
    /**
     * List of answers in different languages
     */
    private List<AnswerTranslate> answersTranslate;

    /**
     * Find answers in database by answer Id and required language.
     *
     * @param answers list of answers
     * @param languageId Id of language
     * @return list of answers of required language in case of successful search and null vice versa
     */
    @Override
    public List<AnswerTranslate> getAnswerTranslateByAnswerIdAndLanguageId(List<Answer> answers, int languageId) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        answersTranslate = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ANSWERID)) {
            preparedStatement.setInt(2, languageId);
            for (Answer answer : answers) {
                preparedStatement.setInt(1, answer.getAnswerId());
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    while (rs.next()) {
                        AnswerTranslate answerTranslate = new AnswerTranslate();
                        answerTranslate.setAnswertranslateId(rs.getInt(1));
                        answerTranslate.setAnswerId(rs.getInt(2));
                        answerTranslate.setAnswerText(rs.getString(3));
                        answerTranslate.setLanguageId(rs.getInt(4));
                        answersTranslate.add(answerTranslate);
                    }
                }
            }
            return answersTranslate;
        } catch (SQLException e) {
            LOGGER.error("Can not get answer by answerId and languageId from database: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }

    /**
     * Insert answer for question in table answertranslate.
     *
     * @param answerId Id of answer which is inserted
     * @param answerText text of answer
     * @param languageId Id of language
     * @param connection connection with database
     * @throws SQLException - if exception deal with database is occurred
     * @return true if answer was inserted and false vice versa
     */
    @Override
    public boolean insertAnswerTranslate(int answerId, String answerText, int languageId, Connection connection)
            throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT,
                Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, answerId);
            preparedStatement.setString(2, answerText);
            preparedStatement.setInt(3, languageId);
            preparedStatement.executeUpdate();
            try(ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return false;
    }
}

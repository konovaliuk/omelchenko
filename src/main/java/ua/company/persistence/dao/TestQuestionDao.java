package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.daofactory.DaoFactory;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.QuestionTranslate;
import ua.company.persistence.idao.IQuestionTranslate;
import ua.company.persistence.idao.ITestQuestion;
import ua.company.service.logger.MyLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TestQuestionDao.java - process requests to table testquestion in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class TestQuestionDao implements ITestQuestion {
    private static final Logger LOGGER = MyLogger.getLOGGER(TestQuestionDao.class);
    private static final String NAME_TABLE = "testquestion";
    private static final String FIND_BY_TEST_ID = "SELECT * FROM " + NAME_TABLE +
            " WHERE testId=?";
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (testId,"
            + " questionId)"
            + " VALUES (?, ?)";
    private List<QuestionTranslate> questionsTranslate;

    /**
     * Find question in database by test Id and required language.
     *
     * @param testId Id of test
     * @param languageId Id of language
     * @return question of required language in case of successful search and null vice versa
     */
    public List<QuestionTranslate> getQuestionByTestId(int testId, int languageId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        questionsTranslate = new ArrayList<>();

        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_TEST_ID))
        {
            preparedStatement.setInt(1, testId);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    IQuestionTranslate iQuestionTranslate = DaoFactory.getIQuestionTranslate();
                    questionsTranslate.add(iQuestionTranslate.
                            getQuestionTranslateByQuestionIdAndLanguageId(rs.getInt(3), languageId));
                }
                return questionsTranslate;
            }
        } catch (SQLException e) {
            LOGGER.error("Get question by testId from database: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }

    /**
     * Insert test and respective question in table questiontest.
     *
     * @param testId Id of test which is inserted
     * @param questionId Id of question
     * @param connection connection with database
     * @throws SQLException - if exception deal with database is occurred
     * @return true if test and question were inserted and false vice versa
     */
    @Override
    public boolean insertTestQuestion(int testId, int questionId, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, testId);
            preparedStatement.setInt(2, questionId);
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

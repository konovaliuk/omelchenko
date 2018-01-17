package ua.company.persistence.dao;

import ua.company.persistence.daofactory.DaoFactory;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.QuestionTranslate;
import ua.company.persistence.idao.IQuestionTranslate;
import ua.company.persistence.idao.ITestQuestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TestQuestionDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class TestQuestionDao implements ITestQuestion {
    private static final String NAME_TABLE = "testquestion";
    private static final String FIND_BY_TEST_ID = "SELECT * FROM " + NAME_TABLE +
            " WHERE testId=?";
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (testId,"
            + " questionId)"
            + " VALUES (?, ?)";
    private List<QuestionTranslate> questionsTranslate;

    public List<QuestionTranslate> getQuestionByTestId(int testId, int languageId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return null;
    }

    @Override
    public boolean insertTestQuestion(int testId, int questionId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, testId);
            preparedStatement.setInt(2, questionId);
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

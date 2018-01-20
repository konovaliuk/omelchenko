package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.Question;
import ua.company.persistence.idao.IQuestion;
import ua.company.service.logger.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * QuestionDao.java - process requests to table question in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 13.12.2017
 */
public class QuestionDao implements IQuestion {
    /**
     * Field class {@Link MyLogger}
     */
    private static final Logger LOGGER = MyLogger.getLOGGER(QuestionDao.class);
    /**
     * Field name of table
     */
    private static final String NAME_TABLE = "question";
    /**
     * SQL query to find question by question Id
     */
    private static final String FIND_BY_QUESTIONID = "SELECT * FROM " + NAME_TABLE +
            " WHERE questionId=?";
    /**
     * SQL query to insert question in table
     */
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (subjectId) VALUES (?)";

    /**
     * Insert parameters of question to table question.
     *
     * @param subjectId indicate the subject of question
     * @return Id of inserted question in case of successful insertion and 0 vice versa
     */
    @Override
    public int insertQuestion(int subjectId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, subjectId);
            preparedStatement.executeUpdate();
            try(ResultSet rs = preparedStatement.getGeneratedKeys()) {
               if (rs.next()) {
                   return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Question was not inserted in database: ", e);
        } finally {
            connectionPool.close();
        }
        return 0;
    }

    /**
     * Find questions in database by question Id received.
     *
     * @param questionId Id of question
     * @return question in case of successful search and null vice versa
     */
    public Question getQuestionById(int questionId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_QUESTIONID))
        {
            preparedStatement.setInt(1, questionId);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Question question = new Question();
                    question.setQuestionId(rs.getInt(1));
                    question.setSubjectId(rs.getInt(2));
                    return question;
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Can not get question by questionId from database: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }
}

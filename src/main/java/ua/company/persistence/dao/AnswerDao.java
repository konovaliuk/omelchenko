package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.Answer;
import ua.company.persistence.idao.IAnswer;
import ua.company.service.logger.MyLogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AnswerDao.java - process requests to table answer in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 13.12.2017
 */
public class AnswerDao implements IAnswer {

    /**
     * Field class {@Link MyLogger}
     */
    private static final Logger LOGGER = MyLogger.getLOGGER(AnswerDao.class);
    /**
     * Field name of table
     */
    private static final String NAME_TABLE = "answer";
    /**
     * SQL query to find answer by question Id
     */
    private static final String FIND_BY_QUESTIONID = "SELECT * FROM " + NAME_TABLE +
            " WHERE questionId=?";
    /**
     * SQL query to find answer by Id
     */
    private static final String FIND_BY_ID = "SELECT * FROM " + NAME_TABLE +
            " WHERE answerId=?";
    /**
     * SQL query to insert answer in table
     */
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (isRight, questionId) VALUES (?, ?)";
    /**
     * field list of answers
     */
    private List <Answer> answers;

    /**
     * Find answers in database for question received.
     *
     * @param questionId Id of question
     * @return list of answers in case of successful search and null vice versa
     */
    public List<Answer> getAnswerByQuestionId(int questionId) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        answers = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_QUESTIONID))
        {
            preparedStatement.setInt(1, questionId);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Answer answer = new Answer();
                    answer.setAnswerId(rs.getInt(1));
                    answer.setIsRightAnswer(rs.getInt(2));
                    answer.setQuestionId(rs.getInt(3));
                    answers.add(answer);
                }
                return answers;
            }
        } catch (SQLException e) {
            LOGGER.error("Can not get answer by questionId from database: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }

    /**
     * Find answer in database according to answer Id.
     *
     * @param answerId Id of answer
     * @return Answer in case of successful search and null vice versa
     */
    @Override
    public Answer getAnswerById(int answerId) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        Answer answer = new Answer();
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID))
        {
            preparedStatement.setInt(1, answerId);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    answer.setAnswerId(rs.getInt(1));
                    answer.setIsRightAnswer(rs.getInt(2));
                    answer.setQuestionId(rs.getInt(3));
                }
                return answer;
            }
        } catch (SQLException e) {
            LOGGER.error("Can not get answer by questionId from database: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }

    /**
     * Insert parameters of answer for question in table answer.
     *
     * @param isRightAnswer indicate if this answer is right
     * @param questionId Id of question for which answer was inserted
     * @param connection connection with database
     * @return Id of inserted Answer in case of successful insertion and 0 vice versa
     */
    @Override
    public int insertAnswer(int isRightAnswer, int questionId, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT,
                Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, isRightAnswer);
            preparedStatement.setInt(2, questionId);
            preparedStatement.executeUpdate();
            try(ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Answer was not inserted in database: ", e);
        }
        return 0;
    }
}

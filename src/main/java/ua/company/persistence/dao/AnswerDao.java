package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.Answer;
import ua.company.persistence.idao.IAnswer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 13.12.2017.
 */
public class AnswerDao implements IAnswer{
    private static final String NAME_TABLE = "answer";
    private static final String FIND_BY_QUESTIONID = "SELECT * FROM " + NAME_TABLE +
            " WHERE questionId=?";
    private static final String FIND_BY_ID = "SELECT * FROM " + NAME_TABLE +
            " WHERE answerId=?";
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (isRight, questionId) VALUES (?, ?)";

    private List <Answer> answers;

    public List<Answer> getAnswerByQuestionId(int questionId) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return null;
    }

    @Override
    public Answer getAnswerById(int answerId) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return null;
    }

    @Override
    public int insertAnswer(int isRightAnswer, int questionId) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, isRightAnswer);
            preparedStatement.setInt(2, questionId);
            preparedStatement.executeUpdate();
            try(ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return 0;
    }
}

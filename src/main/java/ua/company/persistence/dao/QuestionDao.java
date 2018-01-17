package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.Question;
import ua.company.persistence.idao.IQuestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Администратор on 13.12.2017.
 */
public class QuestionDao implements IQuestion {
    private static final String NAME_TABLE = "question";
    private static final String FIND_BY_QUESTIONID = "SELECT * FROM " + NAME_TABLE +
            " WHERE questionId=?";
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (subjectId) VALUES (?)";

    @Override
    public int insertQuestion(int subjectId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return 0;
    }

    public Question getQuestionById(int questionId) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return null;
    }
}

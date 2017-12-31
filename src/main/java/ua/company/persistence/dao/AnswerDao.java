package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionWithoutPool;
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
    List <Answer> answers;

    public List<Answer> getAnswerByQuestionId(int questionId) {
        ConnectionWithoutPool connectionWithoutPool = new ConnectionWithoutPool();
        Connection connection = connectionWithoutPool.connect_to_database();
        answers = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_QUESTIONID))
        {
            preparedStatement.setInt(1, questionId);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Answer answer = new Answer();
                    answer.setAnswerId(rs.getInt(1));
                    answer.setAnswerText(rs.getString(2));
                    answer.setIsRightAnswer(rs.getInt(3));
                    answer.setQuestionId(rs.getInt(4));
                    answers.add(answer);
                }
                return answers;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionWithoutPool.close(connection);
        }
        return null;
    }
}

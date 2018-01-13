package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionWithoutPool;
import ua.company.persistence.domain.Answer;
import ua.company.persistence.domain.AnswerTranslate;
import ua.company.persistence.idao.IAnswerTranslate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * AnswerTranslateDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public class AnswerTranslateDao implements IAnswerTranslate {
    private static final String NAME_TABLE = "answerTranslate";
    private static final String FIND_BY_QUESTIONID = "SELECT * FROM " + NAME_TABLE +
            " WHERE answerId=? AND languageId=?";
    List<AnswerTranslate> answersTranslate;

    @Override
    public List<AnswerTranslate> getAnswerTranslateByAnswerIdAndLanguageId(List<Answer> answers, int languageId) {
        ConnectionWithoutPool connectionWithoutPool = new ConnectionWithoutPool();
        Connection connection = connectionWithoutPool.connect_to_database();
        answersTranslate = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_QUESTIONID)) {
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
            e.printStackTrace();
        } finally {
            connectionWithoutPool.close(connection);
        }
        return null;
    }
}

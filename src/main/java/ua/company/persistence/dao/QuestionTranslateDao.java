package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionWithoutPool;
import ua.company.persistence.domain.QuestionTranslate;
import ua.company.persistence.idao.IQuestionTranslate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * QuestionTranslateDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public class QuestionTranslateDao implements IQuestionTranslate {
    private static final String NAME_TABLE = "questiontranslate";
    private static final String FIND_BY_QUESTIONID_AND_LANGUAGEID = "SELECT * FROM " + NAME_TABLE +
            " WHERE questionId=? AND languageId=?";

    @Override
    public QuestionTranslate getQuestionTranslateByQuestionIdAndLanguageId(int questionId, int languageId) {

        ConnectionWithoutPool connectionWithoutPool = new ConnectionWithoutPool();
        Connection connection = connectionWithoutPool.connect_to_database();
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
            e.printStackTrace();
        } finally {
            connectionWithoutPool.close(connection);
        }
        return null;
    }
}

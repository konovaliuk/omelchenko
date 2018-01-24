package ua.company.persistence.idao;

import ua.company.persistence.domain.Question;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * IQuestion.java - interface for class QuestionDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface IQuestion {

    /**
     * Insert parameters of question to table question.
     *
     * @param subjectId indicate the subject of question
     * @param connection connection with database
     * @throws SQLException - if exception deal with database is occurred
     * @return Id of inserted question in case of successful insertion and 0 vice versa
     */
    int insertQuestion(int subjectId, Connection connection) throws SQLException;

    /**
     * Find questions in database by question Id received.
     *
     * @param questionId Id of question
     * @return question in case of successful search and null vice versa
     */
    Question getQuestionById(int questionId);
}

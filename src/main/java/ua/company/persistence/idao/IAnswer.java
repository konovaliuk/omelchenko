package ua.company.persistence.idao;

import ua.company.persistence.domain.Answer;

import java.sql.Connection;
import java.util.List;

/**
 * IAnswer.java - interface for class AnswerDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface IAnswer {

    /**
     * Find answers in database for question received.
     *
     * @param questionId Id of question
     * @return list of answers in case of successful search and null vice versa
     */
    List<Answer> getAnswerByQuestionId(int questionId);

    /**
     * Find answer in database according to answer Id.
     *
     * @param answerId Id of answer
     * @return Answer in case of successful search and null vice versa
     */
    Answer getAnswerById(int answerId);

    /**
     * Insert parameters of answer for question in table answer.
     *
     * @param isRightAnswer indicate if this answer is right
     * @param questionId Id of question for which answer was inserted
     * @param connection connection with database
     * @return Id of inserted Answer in case of successful insertion and 0 vice versa
     */
    int insertAnswer (int isRightAnswer, int questionId, Connection connection);
}

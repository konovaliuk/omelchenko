package ua.company.persistence.idao;

import ua.company.persistence.domain.Answer;

import java.util.List;

/**
 * IAnswer.java - interface for class AnswerDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface IAnswer {
    List<Answer> getAnswerByQuestionId(int questionId);
    Answer getAnswerById(int answerId);
    int insertAnswer (int isRightAnswer, int questionId);
}

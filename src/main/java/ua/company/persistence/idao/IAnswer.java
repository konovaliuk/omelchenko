package ua.company.persistence.idao;

import java.util.List;

/**
 * IAnswer.java - interface for class AnswerDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface IAnswer {
    List<IQuestion> getAnswerByQuestionId();
}

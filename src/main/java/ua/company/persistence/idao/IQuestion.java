package ua.company.persistence.idao;

import ua.company.persistence.domain.Question;

/**
 * IQuestion.java - interface for class QuestionDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface IQuestion {
    int insertQuestion(int subjectId);
    Question getQuestionById(int questionId);
}

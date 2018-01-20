package ua.company.persistence.idao;

import ua.company.persistence.domain.Question;

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
     * @return Id of inserted question in case of successful insertion and 0 vice versa
     */
    int insertQuestion(int subjectId);

    /**
     * Find questions in database by question Id received.
     *
     * @param questionId Id of question
     * @return question in case of successful search and null vice versa
     */
    Question getQuestionById(int questionId);
}

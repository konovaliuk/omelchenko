package ua.company.persistence.idao;

import ua.company.persistence.domain.Question;

import java.util.List;

/**
 * ITestQuestion.java - interface for class TestQuestionDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface ITestQuestion {
    List<Question> getQuestionByTestId();
}

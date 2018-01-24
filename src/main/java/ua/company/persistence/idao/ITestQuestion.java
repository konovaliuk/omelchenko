package ua.company.persistence.idao;

import ua.company.persistence.domain.QuestionTranslate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * ITestQuestion.java - interface for class TestQuestionDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface ITestQuestion {

    /**
     * Find question in database by test Id and required language.
     *
     * @param testId Id of test
     * @param languageId Id of language
     * @return question of required language in case of successful search and null vice versa
     */
    List<QuestionTranslate> getQuestionByTestId(int testId, int languageId);

    /**
     * Insert test and respective question in table questiontest.
     *
     * @param testId Id of test which is inserted
     * @param questionId Id of question
     * @param connection connection with database
     * @throws SQLException - if exception deal with database is occurred
     * @return true if test and question were inserted and false vice versa
     */
    boolean insertTestQuestion (int testId, int questionId, Connection connection) throws SQLException;
}

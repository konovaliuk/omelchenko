package ua.company.persistence.dao;

import ua.company.persistence.domain.Question;
import ua.company.persistence.idao.ITestQuestion;

import java.sql.Connection;
import java.util.List;

/**
 * TestQuestionDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class TestQuestionDao implements ITestQuestion {
    private Connection connection = null;

    public TestQuestionDao(Connection connection){
        this.connection=connection;
    }

    public List<Question> getQuestionByTestId() {
        return null;
    }
}

package ua.company.persistence.dao;

import ua.company.persistence.daofactory.DaoFactory;
import ua.company.persistence.datasource.ConnectionWithoutPool;
import ua.company.persistence.domain.Question;
import ua.company.persistence.idao.IQuestion;
import ua.company.persistence.idao.ITestQuestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TestQuestionDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class TestQuestionDao implements ITestQuestion {
    private static final String NAME_TABLE = "testquestion";
    private static final String FIND_BY_TEST_ID = "SELECT * FROM " + NAME_TABLE +
            " WHERE testId=?";
    private List<Question> questions;

//    private Connection connection = null;
//    public TestQuestionDao(Connection connection){
//        this.connection=connection;
//    }

    public List<Question> getQuestionByTestId(int testId) {
        ConnectionWithoutPool connectionWithoutPool = new ConnectionWithoutPool();
        Connection connection = connectionWithoutPool.connect_to_database();
        questions = new ArrayList<>();
        //use autocommit?
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_TEST_ID))
        {
            preparedStatement.setInt(1, testId);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    IQuestion iQuestion = DaoFactory.getIQuestion();
                    questions.add(iQuestion.getQuestionById(rs.getInt(3)));
                }
                return questions;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionWithoutPool.close(connection);
        }
        return null;
    }
}

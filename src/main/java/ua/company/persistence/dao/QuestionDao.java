package ua.company.persistence.dao;

import ua.company.persistence.idao.IQuestion;

import java.sql.Connection;

/**
 * Created by Администратор on 13.12.2017.
 */
public class QuestionDao implements IQuestion {
    private Connection connection = null;

    public QuestionDao(Connection connection){
        this.connection=connection;
    }
    public IQuestion getQuestionById() {
        return null;
    }
}

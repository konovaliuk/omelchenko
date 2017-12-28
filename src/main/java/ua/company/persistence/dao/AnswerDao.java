package ua.company.persistence.dao;

import ua.company.persistence.idao.IAnswer;
import ua.company.persistence.idao.IQuestion;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Администратор on 13.12.2017.
 */
public class AnswerDao implements IAnswer{

    private Connection connection = null;

    public AnswerDao(Connection connection){
        this.connection=connection;
    }

    public List<IQuestion> getAnswerByQuestionId() {
        return null;
    }
}

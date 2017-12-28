package ua.company.persistence.dao;

import ua.company.persistence.idao.IResult;

import java.sql.Connection;
import java.util.List;

/**
 * ResultDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class ResultDao implements IResult {
    private Connection connection = null;

    public ResultDao(Connection connection){
        this.connection=connection;
    }

    public void insertResult() {

    }

    public List<IResult> getResultByUser() {
        return null;
    }

    public List<IResult> getResultByTopic() {
        return null;
    }

    public List<IResult> getResultByTest() {
        return null;
    }
}

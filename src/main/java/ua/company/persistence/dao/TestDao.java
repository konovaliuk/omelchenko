package ua.company.persistence.dao;

import ua.company.persistence.idao.ITest;

import java.sql.Connection;

/**
 * TestDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class TestDao implements ITest {
    private Connection connection = null;

    public TestDao(Connection connection){
        this.connection=connection;
    }

    public ITest getTestById() {
        return null;
    }

    public int getTestQuantity() {
        return 0;
    }
}

package ua.company.persistence.idao;

import ua.company.persistence.domain.Test;

/**
 * ITest.java - interface for class TestDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public interface ITest {
    Test getTestById(int testId);
    int getTestQuantity();
}

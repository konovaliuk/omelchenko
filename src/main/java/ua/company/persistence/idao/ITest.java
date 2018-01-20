package ua.company.persistence.idao;

import ua.company.persistence.domain.Test;

/**
 * ITest.java - interface for class TestDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public interface ITest {

    /**
     * Find test in database by test Id.
     *
     * @param testId Id of test
     * @return test in case of successful search and null vice versa
     */
    Test getTestById(int testId);

    /**
     * Find list of tests in database of requested subject Id and return one test according
     * to requested position of test in the list.
     *
     * @param subjectId Id of subject
     * @param testNumber position of test in the tests list
     * @return test in case of successful search and null vice versa
     */
    Test getTestBySubjectId(int subjectId, int testNumber);

    /**
     * Get quantity of tests in database
     *
     * @return quantity of test in database
     */
    int getTestQuantity();

    /**
     * Get quantity of tests in database of requested subject
     *
     * @param subjectId Id of subject
     * @return quantity of test in database of required subject
     */
    int getTestQuantity(int subjectId);

    /**
     * Insert test in table test.
     *
     * @param testName the name of test
     * @param timeLimit the time for deciding test
     * @param subjectId Id of subject
     * @return Id of test if test was inserted and 0 vice versa
     */
    int insertTest (String testName, int timeLimit, int subjectId);
}

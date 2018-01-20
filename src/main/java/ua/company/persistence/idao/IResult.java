package ua.company.persistence.idao;

import ua.company.persistence.domain.Result;
import ua.company.persistence.domain.Test;
import ua.company.persistence.domain.User;

import java.util.List;

/**
 * IResult.java - interface for class ResultDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface IResult {

    /**
     * Insert results of passed quiz.
     *
     * @param user user who finished test
     * @param test test which was passed
     * @param score score of passed test
     * @return true in case of successful insertion and false vice versa
     */
    boolean  insertResult(User user, Test test, double score);

    /**
     * Get results by Students.
     *
     * @return list of results by students in case of successful request and null vice versa
     */
    List<Result> getResults();
}

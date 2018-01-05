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
    boolean  insertResult(User user, Test test, double score);
    List<Result> getResults();
}

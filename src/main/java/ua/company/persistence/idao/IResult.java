package ua.company.persistence.idao;

import java.util.List;

/**
 * IResult.java - interface for class ResultDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface IResult {
    void  insertResult();
    List<IResult> getResultByUser();
    List<IResult> getResultByTopic();
    List<IResult> getResultByTest();
}

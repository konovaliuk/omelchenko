package ua.company.persistence.dao;

import ua.company.persistence.idao.ISubject;

import java.sql.Connection;

/**
 * TopicDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class SubjectDao implements ISubject {
    private Connection connection = null;

    public SubjectDao(Connection connection){
        this.connection=connection;
    }

    public ua.company.persistence.domain.Subject getTopicById() {
        return null;
    }
}

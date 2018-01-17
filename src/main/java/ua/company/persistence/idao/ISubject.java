package ua.company.persistence.idao;

import ua.company.persistence.domain.Subject;

/**
 * ITopic.java - interface for class TopicDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface ISubject {
    String getSubjectNameById(int subjectId);
    Subject getSubjectById(int subjectId);
    int getSubjectIdByName(String subjectName);
}

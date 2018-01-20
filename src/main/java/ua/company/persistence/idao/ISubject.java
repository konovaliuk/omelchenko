package ua.company.persistence.idao;

import ua.company.persistence.domain.Subject;

/**
 * ISubject.java - interface for class SubjectDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface ISubject {

    /**
     * Find subject name in database by subject Id.
     *
     * @param subjectId Id of subject
     * @return subject name in case of successful search and null vice versa
     */
    String getSubjectNameById(int subjectId);

    /**
     * Find subject in database by subject Id.
     *
     * @param subjectId Id of subject
     * @return subject in case of successful search and null vice versa
     */
    Subject getSubjectById(int subjectId);

    /**
     * Find subject Id in database by requested subject name.
     *
     * @param subjectName name of requested subject
     * @return subjectId in case of successful search and 0 vice versa
     */
    int getSubjectIdByName(String subjectName);
}

package ua.company.persistence.domain;

/**
 * Topic.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class Subject {
    private int subjectId;
    private String subjectName;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject() {
    }
}

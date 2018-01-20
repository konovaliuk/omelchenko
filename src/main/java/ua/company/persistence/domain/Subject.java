package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * Subject.java - class for describing entity Subject.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class Subject implements Serializable {
    private int subjectId;
    private String subjectName;

    /**
     * Constructor for creating new object of entity {@link Subject}
     */
    public Subject() {
    }

    /**
     * Receive value of filed {@link Subject#subjectId}
     *
     * @return subject Id
     */
    public int getSubjectId() {
        return subjectId;
    }

    /**
     * Define field {@link Subject#subjectId}
     *
     * @param subjectId - subject Id
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Receive value of filed {@link Subject#subjectName}
     *
     * @return subject name
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Define field {@link Subject#subjectName}
     *
     * @param subjectName - subject name
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * Compare two objects by their field {@link Subject#subjectId}
     *
     * @param o object for comparison
     * @return true if values are equal and false vice versa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        return subjectId == subject.subjectId;

    }

    /**
     * Calculate object hash code of this class
     *
     * @return hashcode of object
     */
    @Override
    public int hashCode() {
        return (subjectId ^ (subjectId >>> 32));
    }

    /**
     * Create string representation of object
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}

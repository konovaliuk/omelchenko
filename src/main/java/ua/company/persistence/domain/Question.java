package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * Question.java - class for describing entity Question.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 28 Dec 2017
 */
public class Question implements Serializable {
    private int questionId;
    private int subjectId;

    /**
     * Constructor for creating new object of entity {@link Question}
     */
    public Question() {
    }

    /**
     * Receive value of filed {@link Question#questionId}
     *
     * @return question Id
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Define field {@link Question#questionId}
     *
     * @param questionId - question Id
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * Receive value of filed {@link Question#subjectId}
     *
     * @return subject Id
     */
    public int getSubjectId() {
        return subjectId;
    }

    /**
     * Define field {@link Question#questionId}
     *
     * @param subjectId - subject Id
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * Compare two objects by their field {@link Question#questionId}
     *
     * @param o object for comparison
     * @return true if values are equal and false vice versa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return questionId == question.questionId;

    }

    /**
     * Calculate object hash code of this class
     *
     * @return hashcode of object
     */
    @Override
    public int hashCode() {
        return (int) (questionId ^ (questionId >>> 32));
    }

    /**
     * Create string representation of object
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", subjectId=" + subjectId +
                '}';
    }
}

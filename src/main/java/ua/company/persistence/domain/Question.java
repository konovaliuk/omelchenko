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

    public Question() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return questionId == question.questionId;

    }

    @Override
    public int hashCode() {
        return (int) (questionId ^ (questionId >>> 32));
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + questionId +
                '}';
    }
}

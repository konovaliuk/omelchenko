package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * Answer.java - class for describing entity Answer.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public class Answer implements Serializable {
    private int answerId;
    private int isRightAnswer;
    private int questionId;

    /**
     * Constructor for creating new object of entity {@link Answer}
     */
    public Answer() {
    }

    /**
     * Receive value of filed {@link Answer#answerId}
     *
     * @return answer Id
     */
    public int getAnswerId() {
        return answerId;
    }

    /**
     * Define field {@link Answer#answerId}
     *
     * @param answerId - answer Id
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * Receive value of filed {@link Answer#isRightAnswer}
     *
     * @return value whether answer is right or not. Variable
     * can take 0 and 1 values, wrong and right respectively.
     */
    public int getIsRightAnswer() {
        return isRightAnswer;
    }

    /**
     * Define field {@link Answer#isRightAnswer}
     *
     * @param isRightAnswer - variable
     * can take 0 and 1 values, wrong and right respectively
     */
    public void setIsRightAnswer(int isRightAnswer) {
        this.isRightAnswer = isRightAnswer;
    }

    /**
     * Receive value of filed {@link Answer#questionId}
     *
     * @return question Id
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Define field {@link Answer#questionId}
     *
     * @param questionId - question Id
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * Compare two objects by their field {@link Answer#answerId}
     *
     * @param o object for comparison
     * @return true if values are equal and false vice versa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        return answerId == answer.answerId;

    }

    /**
     * Calculate object hash code of this class
     *
     * @return hashcode of object
     */
    @Override
    public int hashCode() {
        return (answerId ^ (answerId >>> 32));
    }

    /**
     * Create string representation of object
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "Answer{" +
                "id=" + answerId +
                ", isRightAnswer=" + isRightAnswer +
                '}';
    }
}

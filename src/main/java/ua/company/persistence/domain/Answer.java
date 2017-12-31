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
    private String answerText;
    private int isRightAnswer;
    private int questionId;

    public Answer() {
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getIsRightAnswer() {
        return isRightAnswer;
    }

    public void setIsRightAnswer(int isRightAnswer) {
        this.isRightAnswer = isRightAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        return answerId == answer.answerId;

    }

    @Override
    public int hashCode() {
        return (int) (answerId ^ (answerId >>> 32));
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + answerId +
                ", answerText='" + answerText + '\'' +
                ", isRightAnswer=" + isRightAnswer +
                '}';
    }
}

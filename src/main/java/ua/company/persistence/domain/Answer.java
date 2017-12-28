package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * Answer.java - class for describing entity Answer.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public class Answer implements Serializable {
    private long id;
    private String answerText;
    private boolean isRightAnswer;

    public Answer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isRightAnswer() {
        return isRightAnswer;
    }

    public void setIsRightAnswer(boolean isRightAnswer) {
        this.isRightAnswer = isRightAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        return id == answer.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answerText='" + answerText + '\'' +
                ", isRightAnswer=" + isRightAnswer +
                '}';
    }
}

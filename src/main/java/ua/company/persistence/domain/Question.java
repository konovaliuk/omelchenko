package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * Question.java - class for describing entity Question.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 28 Dec 2017
 */
public class Question implements Serializable {
    private long id;
    private String questionText;
    private String explanation;
    private int timeLimit;
    private int weightCoefficient;

    public Question() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getWeightCoefficient() {
        return weightCoefficient;
    }

    public void setWeightCoefficient(int weightCoefficient) {
        this.weightCoefficient = weightCoefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return id == question.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", explanation='" + explanation + '\'' +
                ", timeLimit=" + timeLimit +
                ", weightCoefficient=" + weightCoefficient +
                '}';
    }
}

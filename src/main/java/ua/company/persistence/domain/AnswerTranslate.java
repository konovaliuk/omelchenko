package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * AnswerTranslate.java - class for describing entity AnswerTranslate.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public class AnswerTranslate implements Serializable {
    private int answertranslateId;
    private int answerId;
    private String answerText;
    private int languageId;

    /**
     * Constructor for creating new object of entity {@link AnswerTranslate}
     */
    public AnswerTranslate() {
    }

    /**
     * Receive value of filed {@link AnswerTranslate#answertranslateId}
     *
     * @return answertranslate Id
     */
    public int getAnswertranslateId() {
        return answertranslateId;
    }

    /**
     * Define field {@link AnswerTranslate#answertranslateId}
     *
     * @param answertranslateId - answerTranslate Id
     */
    public void setAnswertranslateId(int answertranslateId) {
        this.answertranslateId = answertranslateId;
    }

    /**
     * Receive value of filed {@link AnswerTranslate#answerId}
     *
     * @return answer Id
     */
    public int getAnswerId() {
        return answerId;
    }

    /**
     * Define field {@link AnswerTranslate#answerId}
     *
     * @param answerId - answer Id
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * Receive value of filed {@link AnswerTranslate#answerText}
     *
     * @return string representation of answer
     */
    public String getAnswerText() {
        return answerText;
    }

    /**
     * Define field {@link AnswerTranslate#answerText}
     *
     * @param answerText - string representation of answer
     */
    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    /**
     * Receive value of filed {@link AnswerTranslate#languageId}
     *
     * @return language Id
     */
    public int getLanguageId() {
        return languageId;
    }

    /**
     * Define field {@link AnswerTranslate#languageId}
     *
     * @param languageId - language Id
     */
    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    /**
     * Compare two objects by their field {@link AnswerTranslate#answertranslateId}
     *
     * @param o object for comparison
     * @return true if values are equal and false vice versa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerTranslate that = (AnswerTranslate) o;
        return answertranslateId == that.answertranslateId;
    }

    /**
     * Calculate object hash code of this class
     *
     * @return hashcode of object
     */
    @Override
    public int hashCode() {
        return (answertranslateId ^ (answertranslateId >>> 32));
    }

    /**
     * Create string representation of object
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "AnswerTranslate{" +
                "answertranslateId=" + answertranslateId +
                ", answerId=" + answerId +
                ", answerText='" + answerText + '\'' +
                ", languageId=" + languageId +
                '}';
    }
}

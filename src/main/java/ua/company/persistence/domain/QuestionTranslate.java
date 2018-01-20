package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * QuestionTranslate.java - class for describing entity QuestionTranslate.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public class QuestionTranslate implements Serializable {
    private int questiontranslateId;
    private int questionId;
    private String questionText;
    private int languageId;

    /**
     * Constructor for creating new object of entity {@link QuestionTranslate}
     */
    public QuestionTranslate() {
    }

    /**
     * Receive value of filed {@link QuestionTranslate#questiontranslateId}
     *
     * @return questiontranslate Id
     */
    public int getQuestiontranslateId() {
        return questiontranslateId;
    }

    /**
     * Define field {@link QuestionTranslate#questiontranslateId}
     *
     * @param questiontranslateId - questiontranslate Id
     */
    public void setQuestiontranslateId(int questiontranslateId) {
        this.questiontranslateId = questiontranslateId;
    }

    /**
     * Receive value of filed {@link QuestionTranslate#questionId}
     *
     * @return question Id
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Define field {@link QuestionTranslate#questionId}
     *
     * @param questionId - question Id
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * Receive value of filed {@link QuestionTranslate#questionText}
     *
     * @return string representation of question
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Define field {@link QuestionTranslate#questionText}
     *
     * @param questionText - string representation of question
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    /**
     * Receive value of filed {@link QuestionTranslate#languageId}
     *
     * @return language Id
     */
    public int getLanguageId() {
        return languageId;
    }

    /**
     * Define field {@link QuestionTranslate#languageId}
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

        QuestionTranslate that = (QuestionTranslate) o;

        return questiontranslateId == that.questiontranslateId;

    }

    /**
     * Calculate object hash code of this class
     *
     * @return hashcode of object
     */
    @Override
    public int hashCode() {
        return (int) (questiontranslateId ^ (questiontranslateId >>> 32));
    }

    /**
     * Create string representation of object
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "QuestionTranslate{" +
                "questiontranslateId=" + questiontranslateId +
                ", questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", languageId=" + languageId +
                '}';
    }
}

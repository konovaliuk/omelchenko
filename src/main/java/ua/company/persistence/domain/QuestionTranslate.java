package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * QuestionTranslate.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public class QuestionTranslate implements Serializable {
    private int questiontranslateId;
    private int questionId;
    private String questionText;
    private int languageId;

    public QuestionTranslate() {
    }

    public int getQuestiontranslateId() {
        return questiontranslateId;
    }

    public void setQuestiontranslateId(int questiontranslateId) {
        this.questiontranslateId = questiontranslateId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

}

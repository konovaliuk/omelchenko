package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * AnswerTranslate.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public class AnswerTranslate implements Serializable {
    private int answertranslateId;
    private int answerId;
    private String answerText;
    private int languageId;

    public AnswerTranslate() {
    }

    public int getAnswertranslateId() {
        return answertranslateId;
    }

    public void setAnswertranslateId(int answerTranslateId) {
        this.answertranslateId = answertranslateId;
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

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}

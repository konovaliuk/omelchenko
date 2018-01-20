package ua.company.persistence.idao;

import ua.company.persistence.domain.Answer;
import ua.company.persistence.domain.AnswerTranslate;

import java.util.List;

/**
 * IAnswerTranslate.java - interface for class AnswerTranslateDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public interface IAnswerTranslate {

    /**
     * Find answers in database by answer Id and required language.
     *
     * @param answers list of answers
     * @param languageId Id of language
     * @return list of answers of required language in case of successful search and null vice versa
     */
    List<AnswerTranslate> getAnswerTranslateByAnswerIdAndLanguageId (List<Answer> answers, int languageId);

    /**
     * Insert answer for question in table answertranslate.
     *
     * @param answerId Id of answer which is inserted
     * @param answerText text of answer
     * @param languageId Id of language
     * @return true if answer was inserted and false vice versa
     */
    boolean insertAnswerTranslate (int answerId, String answerText, int languageId);
}

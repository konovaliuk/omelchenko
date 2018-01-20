package ua.company.persistence.idao;

import ua.company.persistence.domain.QuestionTranslate;

/**
 * IQuestionTranslate.java - interface for class QuestionTranslateDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public interface IQuestionTranslate {

    /**
     * Find question in database by question Id and required language.
     *
     * @param questionId list of answers
     * @param languageId Id of language
     * @return question of required language in case of successful search and null vice versa
     */
    QuestionTranslate getQuestionTranslateByQuestionIdAndLanguageId(int questionId, int languageId);

    /**
     * Insert question in table questiontranslate.
     *
     * @param questionId Id of question which is inserted
     * @param questionText text of question
     * @param languageId Id of language
     * @return true if question was inserted and false vice versa
     */
    boolean insertQuestionTranslate (int questionId, String questionText, int languageId);
}

package ua.company.persistence.idao;

import ua.company.persistence.domain.QuestionTranslate;

/**
 * IQuestionTranslate.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public interface IQuestionTranslate {
    QuestionTranslate getQuestionTranslateByQuestionIdAndLanguageId(int questionId, int languageId);
}

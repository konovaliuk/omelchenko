package ua.company.persistence.idao;

import ua.company.persistence.domain.Answer;
import ua.company.persistence.domain.AnswerTranslate;

import java.util.List;

/**
 * IAnswerTranslate.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 11.01.2018
 */
public interface IAnswerTranslate {
    List<AnswerTranslate> getAnswerTranslateByAnswerIdAndLanguageId (List<Answer> answers, int languageId);
}

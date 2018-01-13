package ua.company.persistence.idao;

/**
 * ILanguage.java - interface for class LanguageDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface ILanguage {
    int getIdByName(String locale);
}

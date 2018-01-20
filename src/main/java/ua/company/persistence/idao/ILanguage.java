package ua.company.persistence.idao;

/**
 * ILanguage.java - interface for class LanguageDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface ILanguage {

    /**
     * Get Id of language according to requested locale by user.
     *
     * @param locale describe requested language
     * @return languageId of answers of required language in case of successful search and null vice versa
     */
    int getIdByName(String locale);
}

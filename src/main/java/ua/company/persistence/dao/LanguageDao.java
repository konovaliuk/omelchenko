package ua.company.persistence.dao;

import ua.company.persistence.domain.Language;
import ua.company.persistence.idao.ILanguage;

import java.sql.Connection;

/**
 * LanguageDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class LanguageDao implements ILanguage {
    private Connection connection = null;

    public LanguageDao(Connection connection){
        this.connection=connection;
    }

    public Language getLanguageById() {
        return null;
    }
}

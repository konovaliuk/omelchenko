package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.idao.ILanguage;
import ua.company.service.logger.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * LanguageDao.java - process requests to table language in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class LanguageDao implements ILanguage {
    /**
     * Field class {@Link MyLogger}
     */
    private static final Logger LOGGER = MyLogger.getLOGGER(LanguageDao.class);
    /**
     * Field name of table
     */
    private static final String NAME_TABLE = "language";
    /**
     * SQL query to find id of language by name
     */
    private static final String FIND_ID_BY_NAME = "SELECT * FROM " + NAME_TABLE +
            " WHERE name=?";
    /**
     * Field language Id
     */
    private int languageId;

    /**
     * Get Id of language according to requested locale by user.
     *
     * @param locale describe requested language
     * @return languageId of answers of required language in case of successful search and null vice versa
     */
    @Override
    public int getIdByName(String locale) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_BY_NAME))
        {
            preparedStatement.setString(1, locale);
            LOGGER.info("Prepared statement: " + FIND_ID_BY_NAME);
            try(ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    languageId = rs.getInt(1);
                }
                return languageId;
            }
        } catch (SQLException e) {
            LOGGER.error("Can not get Id of language by name: ", e);
        } finally {
            connectionPool.close();
        }
        return 0;
    }
}

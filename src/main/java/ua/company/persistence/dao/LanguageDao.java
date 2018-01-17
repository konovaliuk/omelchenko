package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.Language;
import ua.company.persistence.idao.ILanguage;
import ua.company.service.logger.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * LanguageDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class LanguageDao implements ILanguage {
    private static final Logger LOGGER = MyLogger.getLOGGER(Language.class);
    private static final String NAME_TABLE = "language";
    private static final String FIND_ID_BY_NAME = "SELECT * FROM " + NAME_TABLE +
            " WHERE name=?";
    private int languageId;

    @Override
    public int getIdByName(String locale) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return 0;
    }
}

package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.User;
import ua.company.persistence.idao.IUser;
import ua.company.service.logger.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDao.java - process requests to table user in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class UserDao implements IUser {
    private static final Logger LOGGER = MyLogger.getLOGGER(UserDao.class);
    private static final String NAME_TABLE = "user";
    private static final String INSERT = "INSERT INTO " + NAME_TABLE
            + " (login,"
            + " email,"
            + " password,"
            + " country,"
            + " gender,"
            + " usertypeId)"
            + " VALUES (?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_lOGIN_AND_PASS = "SELECT * FROM " + NAME_TABLE +
            " WHERE login=? and password=?";
    private static final String FIND_ID_BY_lOGIN = "SELECT * FROM " + NAME_TABLE +
            " WHERE login=?";
    private static final String FIND_USERTYPEID_BY_lOGIN = "SELECT * FROM " + NAME_TABLE +
            " WHERE login=?";

    /**
     * Write to database new registered User.
     *
     * @param login      - login of user.
     * @param password   - password of user. Password must start of string, contain at least one digit, lower case and upper case letter, at \
     * least 8 symbols and no whitespace allowed.
     * @param email      - email of user.
     * @param country    - country of user inhabitance.
     * @param gender     - user gender.
     * @param usertypeId - user type Id.
     * @return inserted user in case of successful insertion and null vice versa
     */
    @Override
    public User insertUser(String login, String email, String password, String country,
                           String gender, int usertypeId) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, country);
            preparedStatement.setString(5, gender);
            preparedStatement.setInt(6, usertypeId);
            preparedStatement.executeUpdate();

            User user = new User();
            user.setId(getIdByLogin(login));
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setCountry(country);
            user.setGender(gender);
            user.setUsertypeId(usertypeId);

            return user;
        } catch (SQLException e) {
            LOGGER.error("User was not inserted in database: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }

    /**
     * Find user in database by Login and Password.
     *
     * @param login login of user.
     * @param password password of user.
     * @return user in case of successful search and null vice versa
     */
    @Override
    public User getUserByLoginAndPass(String login, String password) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_lOGIN_AND_PASS)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("userId"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setCountry(rs.getString("country"));
                    user.setGender(rs.getString("gender"));
                    user.setUsertypeId(rs.getInt("usertypeId"));
                    return user;
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Can not get user by login and password: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }

    /**
     * Find user Id in database by Login.
     *
     * @param login login of user.
     * @return Id of user in case of successful search and 0 vice versa
     */
    public int getIdByLogin(String login) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_BY_lOGIN)) {
            preparedStatement.setString(1, login);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("userId");
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Can not get Id by login: ", e);
        } finally {
            connectionPool.close();
        }
        return 0;
    }

    /**
     * Find user type Id in database by Login.
     *
     * @param login login of user.
     * @return Id of user type in case of successful search and 0 vice versa
     */
    @Override
    public int getUserTypeIdByLogin(String login) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_USERTYPEID_BY_lOGIN)) {
            preparedStatement.setString(1, login);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("usertypeId");
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Can not get User type Id by login: ", e);
        } finally {
            connectionPool.close();
        }
        return 0;
    }
}

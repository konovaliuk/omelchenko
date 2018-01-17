package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.User;
import ua.company.persistence.idao.IUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class UserDao implements IUser {

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
     * Write to database new User.
     *
     * @param login      - login of user.
     * @param password   - password of user.
     * @param email      - email of user.
     * @param country    - country of user inhabitance.
     * @param gender     - user gender.
     * @param usertypeId - user type Id.
     */
    @Override
    public User insertUser(String login, String email, String password, String country,
                           String gender, int usertypeId) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            //connectionWithoutPool.close(connection);
            connectionPool.close();
        }
        return null;
    }

    /**
     * Get user from database by Login and Password.
     */
    @Override
    public User getUserByLoginAndPass(String login, String password) {

//        ConnectionWithoutPool connectionWithoutPool = new ConnectionWithoutPool();
//        Connection connection = connectionWithoutPool.connect_to_database();

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            //connectionWithoutPool.close(connection);
            connectionPool.close();
        }
        return null;
    }

    public int getIdByLogin(String login) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        ConnectionWithoutPool connectionWithoutPool = new ConnectionWithoutPool();
//        Connection connection = connectionWithoutPool.connect_to_database();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_BY_lOGIN)) {
            preparedStatement.setString(1, login);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("userId");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.close();
//            connectionWithoutPool.close(connection);
        }
        return 0;
    }

    @Override
    public int getUserTypeIdByLogin(String login) {

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        ConnectionWithoutPool connectionWithoutPool = new ConnectionWithoutPool();
//        Connection connection = connectionWithoutPool.connect_to_database();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_USERTYPEID_BY_lOGIN)) {
            preparedStatement.setString(1, login);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("usertypeId");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.close();
//            connectionWithoutPool.close(connection);
        }
        return 0;
    }
}

package ua.company.persistence.dao;

import ua.company.persistence.domain.User;
import ua.company.persistence.domain.UserType;
import ua.company.persistence.idao.IUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

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
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

//    private static final String FIND_BY_ID = "SELECT * FROM " + NAME_TABLE + " WHERE id=?";

    /**
     * Write to database new User.
     *
     * @param login    - login of user.
     * @param password - password of user.
     * @param email    - email of user.
     * @param country  - country of user inhabitance.
     * @param gender   - user gender.
     * @param userType   - user type.
     */
    public User insertUser(String login, String email, String password, String country,
                              String gender, UserType userType) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, country);
            preparedStatement.setString(5, gender);
            preparedStatement.setInt(6, userType.getUsertypeId());
            preparedStatement.executeUpdate();

            User user = new User();
            user.setId(getIdByLogin(login));
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setCountry(country);
            user.setGender(gender);

//убрать этот close когда пул получится
            connection.close();
//---------------

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get user from database by Login and Password.
     */
    public User getUserByLoginAndPass(String login, String password) {

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
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getIdByLogin(String login){
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_BY_lOGIN)) {
            preparedStatement.setString(1, login);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("userId");
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



    public boolean deleteUser() {
        return false;
    }

    public boolean updateUser() {
        return false;
    }

    public Collection selectCustomersTO() {
        return null;
    }
}

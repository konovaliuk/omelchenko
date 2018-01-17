package ua.company.persistence.dao;

import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.UserType;
import ua.company.persistence.idao.IUserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserTypeDao.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class UserTypeDao implements IUserType {
    private static final String NAME_TABLE = "usertype";
    private static final String FIND_BY_ID = "SELECT * FROM " + NAME_TABLE + " WHERE usertypeid=?";
    private Connection connection = null;

    @Override
    public UserType getUserTypeById(int id) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    UserType userType = new UserType();
                    userType.setUsertypeId(rs.getInt("usertypeid"));
                    userType.setUsertype(rs.getString("usertype"));
                    return userType;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.close();
        }
        return null;
    }
}

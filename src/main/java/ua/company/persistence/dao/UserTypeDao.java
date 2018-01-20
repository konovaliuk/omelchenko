package ua.company.persistence.dao;

import org.apache.log4j.Logger;
import ua.company.persistence.datasource.ConnectionPool;
import ua.company.persistence.domain.UserType;
import ua.company.persistence.idao.IUserType;
import ua.company.service.logger.MyLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserTypeDao.java - process requests to table usertype in database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public class UserTypeDao implements IUserType {
    private static final Logger LOGGER = MyLogger.getLOGGER(UserTypeDao.class);
    private static final String NAME_TABLE = "usertype";
    private static final String FIND_BY_ID = "SELECT * FROM " + NAME_TABLE + " WHERE usertypeid=?";

    /**
     * Find user type in database by type Id.
     *
     * @param id user type id
     * @return user type in case of successful search and null vice versa
     */
    @Override
    public UserType getUserTypeById(int id) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
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
            LOGGER.error("Can not get User type by Id: ", e);
        } finally {
            connectionPool.close();
        }
        return null;
    }
}

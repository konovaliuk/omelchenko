package ua.company.persistence.idao;

import ua.company.persistence.domain.User;
import ua.company.persistence.domain.UserType;

import java.util.Collection;

/**
 * IUser.java - interface for class UserDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public interface IUser {
    User insertUser(String login, String email, String password, String country,
                    String gender, UserType userType);
    User getUserByLoginAndPass(String login, String password);
    boolean deleteUser();
    boolean updateUser();
    Collection selectCustomersTO();
}

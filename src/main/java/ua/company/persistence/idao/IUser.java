package ua.company.persistence.idao;

import ua.company.persistence.domain.User;

/**
 * IUser.java - interface for class UserDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public interface IUser {
    User insertUser(String login, String email, String password, String country,
                    String gender, int usertypeId);
    User getUserByLoginAndPass(String login, String password);
    int getUserTypeIdByLogin(String login);
}

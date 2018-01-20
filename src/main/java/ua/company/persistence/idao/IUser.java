package ua.company.persistence.idao;

import ua.company.persistence.domain.User;

/**
 * IUser.java - interface for class UserDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public interface IUser {

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
    User insertUser(String login, String email, String password, String country,
                    String gender, int usertypeId);

    /**
     * Find user in database by Login and Password.
     *
     * @param login login of user.
     * @param password password of user.
     * @return user in case of successful search and null vice versa
     */
    User getUserByLoginAndPass(String login, String password);

    /**
     * Find user Id in database by Login.
     *
     * @param login login of user.
     * @return Id of user in case of successful search and 0 vice versa
     */
    int getUserTypeIdByLogin(String login);
}

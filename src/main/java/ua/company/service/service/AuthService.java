package ua.company.service.service;

import ua.company.persistence.domain.User;

/**
 * AuthService.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public interface AuthService {
    User registration(String login, String email, String password, String country, String gender);
    User login(String login, String password);
    boolean getAccess(String login, String password);
}

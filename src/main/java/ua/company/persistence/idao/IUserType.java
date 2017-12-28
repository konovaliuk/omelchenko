package ua.company.persistence.idao;

import ua.company.persistence.domain.UserType;

/**
 * IUserType.java - interface for class UserTypeDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface IUserType {
    UserType getUserTypeById(int id);
}

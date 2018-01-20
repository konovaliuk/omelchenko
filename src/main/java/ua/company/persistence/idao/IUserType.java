package ua.company.persistence.idao;

import ua.company.persistence.domain.UserType;

/**
 * IUserType.java - interface for class UserTypeDao.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017
 */
public interface IUserType {

    /**
     * Find user type in database by type Id.
     *
     * @param id user type id
     * @return user type in case of successful search and null vice versa
     */
    UserType getUserTypeById(int id);
}

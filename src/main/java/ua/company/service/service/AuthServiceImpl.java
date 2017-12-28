package ua.company.service.service;

import ua.company.persistence.daofactory.DaoFactory;
import ua.company.persistence.domain.User;
import ua.company.persistence.domain.UserType;
import ua.company.persistence.idao.IUser;
import ua.company.persistence.idao.IUserType;

import java.util.Objects;

/**
 * AuthServiceImpl.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class AuthServiceImpl implements AuthService {
    private static final int STUDENT_TYPE_ID = 2;

    @Override
    public User registration(String login, String email, String password, String country, String gender) {
        IUser iUser = DaoFactory.getIUser();
        IUserType iUserType = DaoFactory.getIUserType();
        UserType userType = iUserType.getUserTypeById(STUDENT_TYPE_ID);
        User user = iUser.insertUser(login, email, password, country, gender, userType);
        user.setAccess(true);
        return user;
    }

    @Override
    public User login(String login, String password) {
        IUser iUser = DaoFactory.getIUser();
        User user = iUser.getUserByLoginAndPass(login, password);
        user.setAccess(true);
            if(Objects.nonNull(user)){
                return user;
            }
        return null;
    }

    @Override
    public boolean getAccess(String login, String password) {
        if(DaoFactory.getIUser().getUserByLoginAndPass(login, password)==null){
            return false;
        }
        return true;
    }
}

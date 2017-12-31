package ua.company.web.command;

import org.apache.log4j.Logger;
import ua.company.persistence.domain.User;
import ua.company.service.logger.MyLogger;
import ua.company.service.service.AuthService;
import ua.company.service.service.AuthServiceImpl;
import ua.company.service.validator.Validator;
import ua.company.web.config.ConfigManager;
import ua.company.web.config.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * RegistrationCommand.java - receive request from user, manage actions deal with user registration
 * and return appropriate page.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class RegistrationCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(RegistrationCommand.class);
    private static final String LOGIN = "login";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String RETYPEPSW = "retypepsw";
    private static final String COUNTRY = "country";
    private static final String GENDER = "gender";
    private String page;
    private boolean registration;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Registration command was chosen.");
        String login = request.getParameter(LOGIN);
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        String retypepassword = request.getParameter(RETYPEPSW);
        String country = request.getParameter(COUNTRY);
        String gender = request.getParameter(GENDER);

        Validator validator = new Validator();
        AuthService authService = new AuthServiceImpl();
        validator.setLogin(login);
        validator.setEmail(email);
        validator.setPassword(password);
        validator.setRetypepsw(retypepassword);
        validator.setGender(gender);

        if (validator.isValid()){
            LOGGER.info("Data entered by User are valid.");
            //whether user with such login and password is already present in database
            registration = !authService.getAccess(login, password);
            if(registration){
                User user = authService.registration(login, email, password, country, gender);
                if(user!=null){
                    request.getSession().setAttribute("user", user);
                    LOGGER.info("Registration is successful.");
                    page = ConfigManager.getInstance().getProperty(ConfigManager.getMAIN());
                }
            }else{
                LOGGER.info("User with such login and password is already present in database.");
                request.setAttribute("errorPassMessage", MessageManager.getInstance().
                        getProperty(MessageManager.getRegistrationError()));
                page = ConfigManager.getInstance().getProperty(ConfigManager.getREGISTRATION());
            }
        }else{
            LOGGER.info("Data entered by User are invalid.");
            request.setAttribute("validator", validator);
            page = ConfigManager.getInstance().getProperty(ConfigManager.getREGISTRATION());
        }
        return page;
    }
}

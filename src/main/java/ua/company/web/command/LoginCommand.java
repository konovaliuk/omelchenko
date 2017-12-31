package ua.company.web.command;

import org.apache.log4j.Logger;
import ua.company.service.logger.MyLogger;
import ua.company.service.service.AuthService;
import ua.company.service.service.AuthServiceImpl;
import ua.company.service.validator.Validator;
import ua.company.web.config.ConfigManager;
import ua.company.web.config.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginCommand.java - receive request from user, manage actions deal with user authorization
 * and return appropriate page.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class LoginCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(LoginCommand.class);
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private String page;
    private boolean access;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Login command was chosen.");
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        AuthService authService = new AuthServiceImpl();
        access=authService.getAccess(login, password);
        Validator validator = new Validator();

        //if such login and password is present in database
        if (access) {
            LOGGER.info("Login and password are present in database.");
            request.getSession().setAttribute("user", authService.login(login, password));
            page = ConfigManager.getInstance().getProperty(ConfigManager.getMAIN());
        } else {
            LOGGER.info("Login and password are not present in database.");
            validator.setLogin(login);
            validator.setPassword(password);
            request.setAttribute("validator", validator);
            request.setAttribute("errorPassMessage", MessageManager.getInstance().
                    getProperty(MessageManager.getLoginError()));
            page = ConfigManager.getInstance().getProperty(ConfigManager.getLOGIN());
        }
        return page;
    }
}

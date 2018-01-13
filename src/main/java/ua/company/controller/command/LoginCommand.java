package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.service.logger.MyLogger;
import ua.company.service.service.AuthService;
import ua.company.service.service.AuthServiceImpl;
import ua.company.service.validator.Validator;
import ua.company.controller.config.ConfigManager;
import ua.company.controller.config.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

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
    private String language;
    private boolean access;
    private Locale locale;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Login command was chosen.");
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        AuthService authService = new AuthServiceImpl();

        Validator validator = new Validator();
        validator.setLogin(login);
        validator.setPassword(password);

        language = (String) request.getSession().getAttribute("language");
        LOGGER.info("Current language: " + language);
        if (language!=null){
            locale = new Locale(language);
            validator.setLocale(locale);
        }

        if (validator.isValidLogin()) {
            access=authService.getAccess(login, password);
            //if such login and password is present in database
            if (access) {
                LOGGER.info("Login and password are present in database.");
                request.getSession().setAttribute("user", authService.login(login, password));
                page = ConfigManager.getInstance().getProperty(ConfigManager.getMAIN());
            } else {
                LOGGER.info("Login and password are not present in database.");
                request.setAttribute("errorPassMessage", MessageManager.getInstance().
                        getProperty(MessageManager.getLoginError()));
                page = ConfigManager.getInstance().getProperty(ConfigManager.getLOGIN());
            }
        } else {
            LOGGER.info("Data entered by User are invalid.");
            request.setAttribute("validator", validator);
            page = ConfigManager.getInstance().getProperty(ConfigManager.getLOGIN());
        }
        return page;
    }
}

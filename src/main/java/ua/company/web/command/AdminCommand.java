package ua.company.web.command;

import org.apache.log4j.Logger;
import ua.company.persistence.domain.User;
import ua.company.service.logger.MyLogger;
import ua.company.service.service.AuthService;
import ua.company.service.service.AuthServiceImpl;
import ua.company.web.config.ConfigManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * AdministratorCommand.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class AdminCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(LoginCommand.class);
    private HashMap<String, Double> resultByLogin;
    private String page;

    AuthService authService = new AuthServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Check in database if this is really admin.");
        User user = (User) request.getSession().getAttribute("user");
        if (authService.getUserTypeId(user.getLogin())) {
            resultByLogin = authService.getResults();
            request.setAttribute("resultByLogin", resultByLogin);
        }
        page = ConfigManager.getInstance().getProperty(ConfigManager.getADMIN());
        return page;
    }
}

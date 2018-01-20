package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.controller.config.ConfigManager;
import ua.company.service.logger.MyLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LogoutCommand.java - process user logout.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class LogoutCommand implements ICommand {
    Logger LOGGER = MyLogger.getLOGGER(LogoutCommand.class);
    private String page;

    /**
     * Logout user.
     *
     * @param request data received from servlet
     * @param response data received from servlet
     * @return path to user login page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        page = ConfigManager.getInstance().getProperty(ConfigManager.getLOGIN());
        return page;
    }
}

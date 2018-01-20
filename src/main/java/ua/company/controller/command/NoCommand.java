package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.controller.config.ConfigManager;
import ua.company.service.logger.MyLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * NoCommand.java - executed if there is no appropriate class for processing user command.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class NoCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(NoCommand.class);

    /**
     * Redirect to user login page.
     *
     * @param request data received from servlet
     * @param response data received from servlet
     * @return path to user login page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("No command was received.");
        return ConfigManager.getInstance().getProperty(ConfigManager.getLOGIN());
    }
}

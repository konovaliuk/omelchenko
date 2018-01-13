package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.service.logger.MyLogger;
import ua.company.controller.config.ConfigManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LogoutCommand.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class LogoutCommand implements ICommand {
    Logger LOGGER = MyLogger.getLOGGER(LogoutCommand.class);
    private String page;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        page = ConfigManager.getInstance().getProperty(ConfigManager.getLOGIN());
        return page;
    }
}

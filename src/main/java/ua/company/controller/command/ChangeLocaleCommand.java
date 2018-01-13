package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.controller.config.ConfigManager;
import ua.company.service.logger.MyLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ChangeLocaleCommand.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 08.01.2018
 */
public class ChangeLocaleCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(ChangeLocaleCommand.class);
    private String requestedLocale;
    private String page;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Change Locale Command");
        LOGGER.info("Current locale: " + request.getSession().getAttribute("language"));
        requestedLocale = request.getParameter("localelang");
        LOGGER.info("Requested locale: " + requestedLocale);

        request.getSession().setAttribute("language", requestedLocale);

        page = ConfigManager.getInstance().getProperty(ConfigManager.getMAIN());
        return page;
    }
}

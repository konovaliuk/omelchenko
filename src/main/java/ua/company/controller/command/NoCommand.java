package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.controller.config.ConfigManager;
import ua.company.service.logger.MyLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * NoCommand.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class NoCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(NoCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("No command was received.");
        return ConfigManager.getInstance().getProperty(ConfigManager.getLOGIN());
    }
}

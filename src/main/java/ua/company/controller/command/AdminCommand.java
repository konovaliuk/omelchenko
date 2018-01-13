package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.controller.config.ConfigManager;
import ua.company.controller.pagination.PaginationHelper;
import ua.company.persistence.domain.User;
import ua.company.service.logger.MyLogger;
import ua.company.service.service.AuthService;
import ua.company.service.service.AuthServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.TreeMap;

/**
 * AdministratorCommand.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class AdminCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(AdminCommand.class);
    private TreeMap<String, Double> resultByLogin;
    private String page;
    private int numberRecords;


    AuthService authService = new AuthServiceImpl();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Admin command.");
        LOGGER.info("Check in database if this is really admin.");
        User user = (User) request.getSession().getAttribute("user");
        if (authService.getUserTypeId(user.getLogin())) {
            resultByLogin = authService.getResults();

            LOGGER.info("Pagination.");
            String requestedPage = request.getParameter("pageNumber");
            LOGGER.info("Requested page is " + requestedPage);
            numberRecords = resultByLogin.size();
            PaginationHelper paginationHelper = new PaginationHelper(numberRecords, requestedPage);
            request.getSession().setAttribute("pages", paginationHelper.getPages());
            request.setAttribute("resultByLogin", paginationHelper.getMapByOffsetAndLength(resultByLogin));
        }
        page = ConfigManager.getInstance().getProperty(ConfigManager.getADMIN());
        return page;
    }
}
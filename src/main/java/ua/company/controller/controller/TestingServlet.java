package ua.company.controller.controller;

import org.apache.log4j.Logger;
import ua.company.controller.command.ICommand;
import ua.company.controller.config.ConfigManager;
import ua.company.service.logger.MyLogger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TestingServlet.java - unique servlet for which receive and process requests from client
 * and give response.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 17.12.2017
 */
public class TestingServlet extends HttpServlet {
    private static final Logger LOGGER = MyLogger.getLOGGER(TestingServlet.class);
    private String page;
    private ControllerHelper controllerHelper = ControllerHelper.getInstance();

    /**
     * Pass parameters to method process.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws IOException      if stream cannot be written to or closed.
     * @throws ServletException if errors are occurred in servlet.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    /**
     * Pass parameters to method process.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws IOException if stream cannot be written to or closed.
     * @throws ServletException if errors are occurred in servlet.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process(request, response);
    }

    /**
     * Processes requests for both HTTP GET and POST methods and forward to required page.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws IOException if stream cannot be written to or closed.
     * @throws ServletException if errors are occurred in servlet.
     */
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("Servlet received info from page.");
        try {

            ICommand command = controllerHelper.getCommand(request);
            page = command.execute(request, response);
            LOGGER.info("Servlet forward to page " + page);
        } catch (ServletException e) {
            LOGGER.error("Exception was occurred in Servlet: ", e);
            page = ConfigManager.getInstance().getProperty(ConfigManager.getERROR());
        } catch (IOException e) {
            LOGGER.error("IOException was occurred: ", e);
            page = ConfigManager.getInstance().getProperty(ConfigManager.getERROR());
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}

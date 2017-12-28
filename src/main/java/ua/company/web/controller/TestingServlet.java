package ua.company.web.controller;


import org.apache.log4j.Logger;
import ua.company.service.logger.MyLogger;
import ua.company.web.command.ICommand;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        process(request, response);
    }

    /**
     * Processes requests for both HTTP GET and POST methods.
     *
     * @param request  servlet request
     * @param response servlet response
     */
    private void process(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Servlet received info from page.");

        ICommand command = controllerHelper.getCommand(request);
        page = command.execute(request, response);
        LOGGER.info("Servlet forward to page" + page);

//        IUser iUser = DaoFactory.getIUser();
//        User user = iUser.getUserByLoginAndPass("admin", "rosronaldo");
//        System.out.println(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            //Fixme
            //e.printStackTrace();
        } catch (IOException e) {
            //Fixme
            //e.printStackTrace();
        }
    }
}

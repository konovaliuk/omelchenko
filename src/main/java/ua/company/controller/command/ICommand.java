package ua.company.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ICommand.java - interface which is implemented by all commands received from user.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public interface ICommand {

    /**
     * Method which must be implemented in command classes.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws IOException if stream cannot be written to or closed.
     * @throws ServletException if errors are occurred in servlet.
     * @return path to page depending on requested command.
     */
    String execute (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

package ua.company.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ICommand.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public interface ICommand {
    String execute (HttpServletRequest request, HttpServletResponse response);
}

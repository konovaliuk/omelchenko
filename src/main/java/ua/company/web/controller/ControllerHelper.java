package ua.company.web.controller;

import org.apache.log4j.Logger;
import ua.company.service.logger.MyLogger;
import ua.company.web.command.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * ControllerHelper.java - class for
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class ControllerHelper {
    private static final Logger LOGGER = MyLogger.getLOGGER(ControllerHelper.class);
    private static ControllerHelper instance = null;
    private HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    /**
     * Fill in HashMap by commands in Constructor.
     *
     */
    private ControllerHelper(){
        commands.put("login", new LoginCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("test", new TestCommand());
        commands.put("answer", new AnswerCommand());
        commands.put("admin", new AdminCommand());
        commands.put("logout", new LogoutCommand());
    }

    public ICommand getCommand(HttpServletRequest request){
        LOGGER.info("Controller start to find necessary command.");
        //to receive command from request
        String action = request.getParameter("command");
        //to get object which respond to command
        ICommand iCommand = commands.get(action);
        if (iCommand==null){
            iCommand = new NoCommand();
        }
        return iCommand;
      }

    /**
     * Create object of ControllerHelper class.
     *
     */
    public static ControllerHelper getInstance(){
        if (instance==null){
            instance = new ControllerHelper();
        }
        return instance;
    }
}

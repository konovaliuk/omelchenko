package ua.company.web.command;

import org.apache.log4j.Logger;
import ua.company.persistence.domain.Answer;
import ua.company.persistence.domain.Question;
import ua.company.persistence.domain.Test;
import ua.company.persistence.domain.User;
import ua.company.service.logger.MyLogger;
import ua.company.service.service.AuthService;
import ua.company.service.service.AuthServiceImpl;
import ua.company.web.config.ConfigManager;
import ua.company.web.config.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * StartTestCommand.java - receive request from user, manage actions deal with quiz start
 * and return appropriate page.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class TestCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(LoginCommand.class);
    private Test test;
    private HashMap<Question, List<Answer>> quiz;
    private String page;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Test command was chosen.");
        User user = (User) request.getSession().getAttribute("user");
        if (user!=null){
            AuthService authService = new AuthServiceImpl();
            LOGGER.info("Generating random test.");
            test = authService.generateTest();
            LOGGER.info("Create questions and answers for test.");
            quiz = authService.getQuestionAndAnswer(test);
            request.getSession().setAttribute("test", test);
            request.getSession().setAttribute("quiz", quiz);
            page = ConfigManager.getInstance().getProperty(ConfigManager.getTEST());
        } else{
            LOGGER.info("User is not authorized.");
            request.setAttribute("errorPassMessage", MessageManager.getInstance().
                    getProperty(MessageManager.getStartQuizError()));
            page = ConfigManager.getInstance().getProperty(ConfigManager.getTEST());
        }
        return page;
    }
}

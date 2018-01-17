package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.controller.config.AppManager;
import ua.company.persistence.domain.*;
import ua.company.service.logger.MyLogger;
import ua.company.service.service.AuthService;
import ua.company.service.service.AuthServiceImpl;
import ua.company.controller.config.ConfigManager;
import ua.company.controller.config.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * StartTestCommand.java - receive request from user, manage actions deal with quiz start
 * and return appropriate page.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class QuizCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(QuizCommand.class);
    private Test test;
    private HashMap<QuestionTranslate, List<AnswerTranslate>> showQuiz;
    private String page;
    private String language;
    private Locale locale;
    private User user;
    private Subject subject;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Quiz command was chosen.");
        user = (User) request.getSession().getAttribute("user");
        subject = (Subject) request.getSession().getAttribute("subject");
        language = (String) request.getSession().getAttribute("language");
        LOGGER.info("Current language: " + language);
        if (language != null) {
            locale = new Locale(language);
        } else {
            locale = new Locale(AppManager.getInstance().getProperty(AppManager.getDefaultLanguage()));
        }
        LOGGER.info("Current locale: " + locale);

        if (user != null) {
            AuthService authService = new AuthServiceImpl();
            LOGGER.info("Generating random test.");
            test = authService.generateTest(subject);

            if (test != null) {
                LOGGER.info("Create questions and answers for test.");
                showQuiz = authService.getQuestionAndAnswer(test, locale);
                request.getSession().setAttribute("test", test);
                request.getSession().setAttribute("showQuiz", showQuiz);
                request.setAttribute("start", true);
            } else {
                request.setAttribute("errorPassMessage", MessageManager.getInstance(locale).
                        getProperty(MessageManager.getEmptySubjectError()));
            }
        } else {
            LOGGER.info("User is not authorized.");
            request.setAttribute("errorPassMessage", MessageManager.getInstance(locale).
                    getProperty(MessageManager.getStartQuizError()));
        }
        page = ConfigManager.getInstance().getProperty(ConfigManager.getTEST());
        return page;
    }
}

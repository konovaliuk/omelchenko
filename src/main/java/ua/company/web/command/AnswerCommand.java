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
 * Answer.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class AnswerCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(LoginCommand.class);
    private HashMap<Question, List<Answer>> quiz;
    private List<Answer> wrongAnswers;
    private String page;
    private double score;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String[] userAnswerId = request.getParameterValues("userAnswer");
        LOGGER.info("Receive right answers.");

        if (userAnswerId!=null) {
            AuthService authService = new AuthServiceImpl();
            LOGGER.info("Answer command was chosen.");
            LOGGER.info("Users answers are received.");
            quiz = (HashMap<Question, List<Answer>>) request.getSession().getAttribute("quiz");

            LOGGER.info("To get wrong answers.");
            wrongAnswers = authService.findWrongAnswers(quiz, userAnswerId);
            score = authService.getScore();

            request.setAttribute("wrongAnswers", wrongAnswers);
            request.setAttribute("score", score);

            LOGGER.info("Get user and test from session in order to write in database results.");
            User user = (User) request.getSession().getAttribute("user");
            Test test = (Test) request.getSession().getAttribute("test");

            LOGGER.info("Writing to database...");
            authService.writeResult(user, test, score);

            LOGGER.info("Delete quiz and test attributes.");
            request.getSession().removeAttribute("quiz");
            request.getSession().removeAttribute("test");

            page = ConfigManager.getInstance().getProperty(ConfigManager.getTEST());

        }else{
            LOGGER.info("User did not start to answer.");
            request.setAttribute("errorPassMessage", MessageManager.getInstance().
                    getProperty(MessageManager.getFinishQuizError()));
            page = ConfigManager.getInstance().getProperty(ConfigManager.getTEST());
        }
        return page;
    }
}

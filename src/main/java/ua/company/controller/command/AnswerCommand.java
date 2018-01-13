package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.controller.config.ConfigManager;
import ua.company.persistence.domain.*;
import ua.company.service.logger.MyLogger;
import ua.company.service.service.AuthService;
import ua.company.service.service.AuthServiceImpl;

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
    private static final Logger LOGGER = MyLogger.getLOGGER(AnswerCommand.class);
    private HashMap<QuestionTranslate, List<AnswerTranslate>> showQuiz;
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
            //quiz = (HashMap<Question, List<Answer>>) request.getSession().getAttribute("showQuiz");
            showQuiz = (HashMap<QuestionTranslate, List<AnswerTranslate>>) request.getSession().
                    getAttribute("showQuiz");

            LOGGER.info("To get wrong answers.");
            wrongAnswers = authService.findWrongAnswers(showQuiz, userAnswerId);
            score = authService.getScore();

            request.setAttribute("wrongAnswers", wrongAnswers);
            request.setAttribute("score", score);

            LOGGER.info("Get user and test from session in order to write in database results.");
            User user = (User) request.getSession().getAttribute("user");
            Test test = (Test) request.getSession().getAttribute("test");
//            Test test = (Test) request.getAttribute("testResult");

            LOGGER.info("Writing to database..." + test);
            authService.writeResult(user, test, score);

            LOGGER.info("Delete quiz and test attributes.");
            request.getSession().removeAttribute("quiz");
            request.getSession().removeAttribute("test");

            page = ConfigManager.getInstance().getProperty(ConfigManager.getTEST());

        }else{
            LOGGER.info("User did not start to answer.");
//            request.setAttribute("errorPassMessage", MessageManager.getInstance().
//                    getProperty(MessageManager.getFinishQuizError()));
            request.getSession().removeAttribute("quiz");
            request.getSession().removeAttribute("test");
            page = ConfigManager.getInstance().getProperty(ConfigManager.getTEST());
        }
        return page;
    }
}

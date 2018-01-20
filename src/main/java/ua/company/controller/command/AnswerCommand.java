package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.controller.config.ConfigManager;
import ua.company.persistence.domain.*;
import ua.company.service.emailgenerator.EmailSender;
import ua.company.service.emailgenerator.EmailSenderImpl;
import ua.company.service.logger.MyLogger;
import ua.company.service.service.AuthService;
import ua.company.service.service.AuthServiceImpl;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * AnswerCommand.java - process answers for quiz questions from students.
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

    /**
     * Send to the class {@link AuthService} answers from user and receive wrong answer and score
     * of passed quiz. Pass to the class {@link EmailSender} score.
     *
     * @param request data received from servlet
     * @param response data received from servlet
     * @return path to quiz page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Answer command.");
        String[] userAnswerId = request.getParameterValues("userAnswer");
        LOGGER.info("Receive right answers.");

        if (userAnswerId!=null) {
            AuthService authService = new AuthServiceImpl();
            LOGGER.info("Answer command was chosen.");
            LOGGER.info("Users answers are received.");

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

            LOGGER.info("Writing to database..." + test);
            authService.writeResult(user, test, score);

            EmailSender emailSender = new EmailSenderImpl(user.getEmail());
            try {
                emailSender.sendEmail(user.getLogin(), score);
            } catch (MessagingException e) {
                LOGGER.error("Email can not be sent: ", e);
            }

            LOGGER.info("Delete quiz and test attributes.");
            request.getSession().removeAttribute("quiz");
            request.getSession().removeAttribute("test");
            page = ConfigManager.getInstance().getProperty(ConfigManager.getTEST());

        }else{
            LOGGER.info("User did not start to answer.");
            request.getSession().removeAttribute("quiz");
            request.getSession().removeAttribute("test");
            page = ConfigManager.getInstance().getProperty(ConfigManager.getTEST());
        }
        return page;
    }
}

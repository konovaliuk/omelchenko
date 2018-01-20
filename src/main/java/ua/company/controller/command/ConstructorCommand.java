package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.controller.config.AppManager;
import ua.company.controller.config.ConfigManager;
import ua.company.controller.config.MessageManager;
import ua.company.service.logger.MyLogger;
import ua.company.service.service.AuthService;
import ua.company.service.service.AuthServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * ConstructorCommand.java - process new test, questions and answers which was inputted by admin.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 16.01.2018
 */
public class ConstructorCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(ConstructorCommand.class);
    private String subject;
    private List<String> subjectsArr;
    private String question;
    private String questionUkr;
    private List<String> questions;
    private List<List<String>> questionsArr;
    private List<String> answersEng;
    private List<List<String>> answersEngArr;
    private List<String> answersUkr;
    private List<List<String>> answersUkrArr;
    private List<String> isRight;
    private List<List<String>> isRightArr;
    private String page;
    private Integer questionNumber = 0;

    /**
     * Receive from user questions and answers for creating new test and pass for
     * processing to {@link AuthService}.
     *
     * @param request data received from servlet
     * @param response data received from servlet
     * @return path to admin page when quiz creation was finished and constructor page when
     * quiz creating is in process or data entered by admin are invalid.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Constructor command.");
        LOGGER.info("Get information about creation new test.");
        question = request.getParameter("question");
        questionUkr = request.getParameter("questionUkr");
        subject = request.getParameter("subject");

        LOGGER.info("Parameters: subject - " + subject + "answer1 - " + request.getParameter("answer1") +
                "answer2 - " + request.getParameter("answer2") +
                "answerUkr1 - " + request.getParameter("answer1Ukr") +
                "answerUkr2 - " + request.getParameter("answer2Ukr"));

        if (!question.equals("") && !questionUkr.equals("") && !request.getParameter("answer1").equals("") &&
                !request.getParameter("answer2").equals("") && !request.getParameter("answer1Ukr").equals("") &&
                !request.getParameter("answer2Ukr").equals("")) {

            if (questionsArr == null) {
                questionsArr = new ArrayList<>();
                subjectsArr = new ArrayList<>();
                answersEngArr = new ArrayList<>();
                answersUkrArr = new ArrayList<>();
                isRightArr = new ArrayList<>();
            }

            LOGGER.info("Put information into array.");

            questions = new ArrayList<>();
            questions.add(questionUkr);
            questions.add(question);
            questionsArr.add(questions);

            subjectsArr.add(subject);

            answersEng = new ArrayList<>();
            answersUkr = new ArrayList<>();
            isRight = new ArrayList<>();

            answersEng.add(request.getParameter("answer1"));
            answersEng.add(request.getParameter("answer2"));
            answersEng.add(request.getParameter("answer3"));
            answersEng.add(request.getParameter("answer4"));
            answersEng.add(request.getParameter("answer5"));

            answersUkr.add(request.getParameter("answer1Ukr"));
            answersUkr.add(request.getParameter("answer2Ukr"));
            answersUkr.add(request.getParameter("answer3Ukr"));
            answersUkr.add(request.getParameter("answer4Ukr"));
            answersUkr.add(request.getParameter("answer5Ukr"));

            isRight.add(request.getParameter("isRight1"));
            isRight.add(request.getParameter("isRight2"));
            isRight.add(request.getParameter("isRight3"));
            isRight.add(request.getParameter("isRight4"));
            isRight.add(request.getParameter("isRight5"));

            answersEngArr.add(answersEng);
            answersUkrArr.add(answersUkr);
            isRightArr.add(isRight);

            questionNumber++;
            if (questionNumber == Integer.parseInt(AppManager.getInstance().getProperty
                    (AppManager.getNumberQuestionsInTest()))) {
                AuthService authService = new AuthServiceImpl();
                LOGGER.info("Test is writing to database.");
                authService.writeTest(questionsArr, subjectsArr, answersEngArr, answersUkrArr, isRightArr);
                page = ConfigManager.getInstance().getProperty(ConfigManager.getADMIN());
            } else {
                page = ConfigManager.getInstance().getProperty(ConfigManager.getCONSTRUCTOR());
            }
        } else {
            LOGGER.info("Data entered by Admin are invalid.");
            request.setAttribute("errorPassMessage", MessageManager.getInstance().
                    getProperty(MessageManager.getConstructorError()));
            page = ConfigManager.getInstance().getProperty(ConfigManager.getCONSTRUCTOR());
        }
        return page;
    }
}

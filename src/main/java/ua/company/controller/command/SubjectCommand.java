package ua.company.controller.command;

import org.apache.log4j.Logger;
import ua.company.controller.config.ConfigManager;
import ua.company.persistence.domain.Subject;
import ua.company.service.logger.MyLogger;
import ua.company.service.service.AuthService;
import ua.company.service.service.AuthServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SubjectCommand.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 13.01.2018
 */
public class SubjectCommand implements ICommand {
    private static final Logger LOGGER = MyLogger.getLOGGER(SubjectCommand.class);
    private int subjectId;
    private String page;
    private Subject subject;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Subject command.");
        AuthService authService = new AuthServiceImpl();
        subjectId = Integer.valueOf(request.getParameter("subject_id"));
        subject = authService.getSubject(subjectId);
        LOGGER.info("Subject: " + subject.getSubjectName());
        request.getSession().setAttribute("subject", subject);
        page = ConfigManager.getInstance().getProperty(ConfigManager.getTEST());
        return page;
    }
}

package ua.company.web.config;

import java.util.ResourceBundle;

/**
 * MessageManager.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class MessageManager {
    private static MessageManager instance;
    private ResourceBundle resourceBundle;
    private static final String BUNDLE_NAME = "config.messages";
    private static final String LOGIN_ERROR = "LOGIN_ERROR";
    private static final String REGISTRATION_ERROR = "REGISTRATION_ERROR";
    private static final String STARTQUIZ_ERROR = "STARTQUIZ_ERROR";
    private static final String FINISHQUIZ_ERROR = "FINISHQUIZ_ERROR";
    private static final String SERVLET_EXCEPTION_ERROR_MESSAGE = "SERVLET_EXCEPTION_ERROR_MESSAGE";
    private static final String IO_EXCEPTION_ERROR_MESSAGE="IO_EXCEPTION_ERROR_MESSAGE";

    public static String getLoginError() {
        return LOGIN_ERROR;
    }

    public static String getRegistrationError() {
        return REGISTRATION_ERROR;
    }

    public static String getStartQuizError() {
        return STARTQUIZ_ERROR;
    }

    public static String getFinishQuizError() {
        return FINISHQUIZ_ERROR;
    }

    public static String getServletExceptionErrorMessage() {
        return SERVLET_EXCEPTION_ERROR_MESSAGE;
    }

    public static String getIoExceptionErrorMessage() {
        return IO_EXCEPTION_ERROR_MESSAGE;
    }

    public static MessageManager getInstance(){
        if (instance==null){
            instance = new MessageManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key){
        return (String)resourceBundle.getObject(key);
    }
}

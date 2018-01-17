package ua.company.controller.config;

import java.util.Locale;
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
    private static final String IO_EXCEPTION_ERROR_MESSAGE = "IO_EXCEPTION_ERROR_MESSAGE";
    private static final String EMPTY_EMAIL = "EMPTY_EMAIL";
    private static final String INVALID_EMAIL = "INVALID_EMAIL";
    private static final String INVALID_PASSWORD = "INVALID_PASSWORD";
    private static final String EMPTY_lOGIN = "EMPTY_lOGIN";
    private static final String INVALID_GENDER = "INVALID_GENDER";
    private static final String INVALID_RETYPEPSW = "INVALID_RETYPEPSW";
    private static final String EMPTY_SUBJECT = "EMPTY_SUBJECT";
    private static final String CONSTRUCTOR_ERROR = "CONSTRUCTOR_ERROR";

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

    public static String getEmptyEmail() {
        return EMPTY_EMAIL;
    }

    public static String getInvalidEmail() {
        return INVALID_EMAIL;
    }

    public static String getInvalidPassword() {
        return INVALID_PASSWORD;
    }

    public static String getEmptylogin() {
        return EMPTY_lOGIN;
    }

    public static String getInvalidGender() {
        return INVALID_GENDER;
    }

    public static String getInvalidRetypepsw() {
        return INVALID_RETYPEPSW;
    }

    public static String getEmptySubjectError(){
        return EMPTY_SUBJECT;
    }

    public static String getConstructorError() {
        return CONSTRUCTOR_ERROR;
    }

    public static MessageManager getInstance(){
        if (instance==null){
            instance = new MessageManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }
    public static MessageManager getInstance(Locale locale){
        if (instance==null){
            instance = new MessageManager();
        }
        instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
        return instance;
    }

    public String getProperty(String key){
        return (String)resourceBundle.getObject(key);
    }
}

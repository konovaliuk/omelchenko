package ua.company.controller.config;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * MessageManager.java - configure error messages for displaying to user in case of errors.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class MessageManager {
    private static final String BUNDLE_NAME = "config.messages";
    private static final String LOGIN_ERROR = "LOGIN_ERROR";
    private static final String REGISTRATION_ERROR = "REGISTRATION_ERROR";
    private static final String STARTQUIZ_ERROR = "STARTQUIZ_ERROR";
    private static final String EMPTY_EMAIL = "EMPTY_EMAIL";
    private static final String INVALID_EMAIL = "INVALID_EMAIL";
    private static final String INVALID_PASSWORD = "INVALID_PASSWORD";
    private static final String EMPTY_lOGIN = "EMPTY_lOGIN";
    private static final String INVALID_GENDER = "INVALID_GENDER";
    private static final String INVALID_RETYPEPSW = "INVALID_RETYPEPSW";
    private static final String EMPTY_SUBJECT = "EMPTY_SUBJECT";
    private static final String CONSTRUCTOR_ERROR = "CONSTRUCTOR_ERROR";
    private static MessageManager instance;
    private ResourceBundle resourceBundle;

    /**
     * Receive value of field {@link MessageManager#LOGIN_ERROR}
     *
     * @return message about incorrect login
     */
    public static String getLoginError() {
        return LOGIN_ERROR;
    }

    /**
     * Receive value of field {@link MessageManager#REGISTRATION_ERROR}
     *
     * @return message about impossibility to register such user
     */
    public static String getRegistrationError() {
        return REGISTRATION_ERROR;
    }

    /**
     * Receive value of field {@link MessageManager#STARTQUIZ_ERROR}
     *
     * @return message about necessity to login before start quiz
     */
    public static String getStartQuizError() {
        return STARTQUIZ_ERROR;
    }

    /**
     * Receive value of field {@link MessageManager#EMPTY_EMAIL}
     *
     * @return message about empty email
     */
    public static String getEmptyEmail() {
        return EMPTY_EMAIL;
    }

    /**
     * Receive value of field {@link MessageManager#INVALID_EMAIL}
     *
     * @return message about not valid e-mail
     */
    public static String getInvalidEmail() {
        return INVALID_EMAIL;
    }

    /**
     * Receive value of field {@link MessageManager#INVALID_PASSWORD}
     *
     * @return message about not valid password
     */
    public static String getInvalidPassword() {
        return INVALID_PASSWORD;
    }

    /**
     * Receive value of field {@link MessageManager#EMPTY_lOGIN}
     *
     * @return message about empty login
     */
    public static String getEmptylogin() {
        return EMPTY_lOGIN;
    }

    /**
     * Receive value of field {@link MessageManager#INVALID_GENDER}
     *
     * @return message about user did not choose sex
     */
    public static String getInvalidGender() {
        return INVALID_GENDER;
    }

    /**
     * Receive value of field {@link MessageManager#INVALID_RETYPEPSW}
     *
     * @return message about passwords do not match
     */
    public static String getInvalidRetypepsw() {
        return INVALID_RETYPEPSW;
    }

    /**
     * Receive value of field {@link MessageManager#EMPTY_SUBJECT}
     *
     * @return message about absence of test on chosen subject
     */
    public static String getEmptySubjectError(){
        return EMPTY_SUBJECT;
    }

    /**
     * Receive value of field {@link MessageManager#CONSTRUCTOR_ERROR}
     *
     * @return message about improper constructing new test
     */
    public static String getConstructorError() {
        return CONSTRUCTOR_ERROR;
    }

    /**
     * Return or create object of MessageManager class.
     *
     * @return MessageManager instance of class.
     */
    public static MessageManager getInstance(){
        if (instance==null){
            instance = new MessageManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    /**
     * Return or create object of MessageManager class.
     *
     * @param locale specify language of message
     * @return instance of MessageManager class.
     */
    public static MessageManager getInstance(Locale locale){
        if (instance==null){
            instance = new MessageManager();
        }
        instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
        return instance;
    }

    /**
     * Get error message from messages.properties according to key specified by
     * methods of this class.
     *
     * @param key specify what error messages should be received
     * @return necessary message according to received key
     */
    public String getProperty(String key){
        return (String)resourceBundle.getObject(key);
    }
}

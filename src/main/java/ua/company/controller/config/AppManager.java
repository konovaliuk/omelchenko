package ua.company.controller.config;

import ua.company.service.emailgenerator.EmailSender;
import java.util.ResourceBundle;

/**
 * AppManager.java - get application resources such as default encoding, default language,
 * structure of test and mailing parameters.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 06.01.2018
 */
public class AppManager {
    public static final String ENCODING = "ENCODING";
    private static final String DEFAULT_RECORDS_PER_PAGE = "DEFAULT_RECORDS_PER_PAGE";
    private static final String DEFAULT_LANGUAGE = "DEFAULT_LANGUAGE";
    private static final String SMTP_HOST = "SMTP_HOST";
    private static final String SMTP_PORT = "SMTP_PORT";
    private static final String EMAIL_ADRESS = "EMAIL_ADRESS";
    private static final String EMAIL_LOGIN = "EMAIL_LOGIN";
    private static final String EMAIL_PASSWORD = "EMAIL_PASSWORD";
    private static final String NUMBER_QUESTIONS_IN_TEST = "NUMBER_QUESTIONS_IN_TEST";
    private static final String BUNDLE_NAME = "config.app";
    private static AppManager instance;
    private ResourceBundle resourceBundle;

    /**
     * Receive value of field {@link AppManager#ENCODING}
     *
     * @return default encoding
     */
    public static String getENCODING() {
        return ENCODING;
    }

    /**
     * Receive value of field {@link AppManager#DEFAULT_RECORDS_PER_PAGE}
     *
     * @return default number of records in report per page
     */
    public static String getDefaultRecordsPerPage() {
        return DEFAULT_RECORDS_PER_PAGE;
    }

    /**
     * Receive value of field {@link AppManager#DEFAULT_LANGUAGE}
     *
     * @return default language of pages
     */
    public static String getDefaultLanguage() {
        return DEFAULT_LANGUAGE;
    }

    /**
     * Receive value of field {@link AppManager#SMTP_HOST}
     *
     * @return smtp host
     */
    public static String getSmtpHost() {
        return SMTP_HOST;
    }

    /**
     * Receive value of field {@link AppManager#SMTP_PORT}
     *
     * @return smtp port
     */
    public static String getSmtpPort() {
        return SMTP_PORT;
    }

    /**
     * Receive value of field {@link AppManager#EMAIL_ADRESS}
     *
     * @return email address from which e-mails about results will be sent by
     * class {@link EmailSender}
     */
    public static String getEmailAdress() {
        return EMAIL_ADRESS;
    }

    /**
     * Receive value of field {@link AppManager#EMAIL_LOGIN}
     *
     * @return login to send e-mail
     */
    public static String getEmailLogin() {
        return EMAIL_LOGIN;
    }

    /**
     * Receive value of field {@link AppManager#EMAIL_PASSWORD}
     *
     * @return password to send e-mail
     */
    public static String getEmailPassword() {
        return EMAIL_PASSWORD;
    }

    /**
     * Receive value of field {@link AppManager#NUMBER_QUESTIONS_IN_TEST}
     *
     * @return number of questions in quiz
     */
    public static String getNumberQuestionsInTest() {
        return NUMBER_QUESTIONS_IN_TEST;
    }

    /**
     * Return or create object of AppManager class.
     *
     * @return instance of Appmanager class.
     */
    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    /**
     * Receive value of parameters from application properties according to key specified by
     * methods of this class.
     *
     * @param key specify what page should be received
     * @return necessary parameter according to received key
     */
    public String getProperty(String key) {
        return (String) resourceBundle.getObject(key);
    }
}

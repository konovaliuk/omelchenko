package ua.company.controller.config;

import java.util.ResourceBundle;

/**
 * AppManager.java -
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

    public static String getENCODING() {
        return ENCODING;
    }

    public static String getDefaultRecordsPerPage() {
        return DEFAULT_RECORDS_PER_PAGE;
    }

    public static String getDefaultLanguage() {
        return DEFAULT_LANGUAGE;
    }

    public static String getSmtpHost() {
        return SMTP_HOST;
    }

    public static String getSmtpPort() {
        return SMTP_PORT;
    }

    public static String getEmailAdress() {
        return EMAIL_ADRESS;
    }

    public static String getEmailLogin() {
        return EMAIL_LOGIN;
    }

    public static String getEmailPassword() {
        return EMAIL_PASSWORD;
    }

    public static String getNumberQuestionsInTest() {
        return NUMBER_QUESTIONS_IN_TEST;
    }

    /**
     * Create object of AppManager class.
     *
     */
    public static AppManager getInstance(){
        if (instance==null){
            instance = new AppManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key){
        return (String) resourceBundle.getObject(key);
    }
}

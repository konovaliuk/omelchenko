package ua.company.controller.config;

import java.util.ResourceBundle;

/**
 * config.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class ConfigManager {
    private static final String MAIN = "MAIN";
    private static final String ERROR = "ERROR";
    private static final String LOGIN = "LOGIN";
    private static final String REGISTRATION = "REGISTRATION";
    private static final String TEST = "TEST";
    private static final String ANSWER = "ANSWER";
    private static final String ADMIN = "ADMIN";
    private static final String LOGOUT = "LOGOUT";
    private static final String BUNDLE_NAME = "config.config";
    private static ConfigManager instance;
    private ResourceBundle resourceBundle;

    public static String getMAIN() {
        return MAIN;
    }

    public static String getERROR() {
        return ERROR;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getREGISTRATION() {
        return REGISTRATION;
    }

    public static String getTEST() {
        return TEST;
    }

    public static String getANSWER() {
        return ANSWER;
    }

    public static String getADMIN() {
        return ADMIN;
    }

    public static String getLOGOUT() {
        return LOGOUT;
    }

    /**
     * Create object of ConfigManager class.
     *
     */
    public static ConfigManager getInstance(){
        if (instance==null){
            instance = new ConfigManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    /**
     * Get page adress from config.properties.
     *
     */
    public String getProperty(String key){
        return (String) resourceBundle.getObject(key);
    }
}

package ua.company.controller.config;

import java.util.ResourceBundle;

/**
 * ConfigManager.java - configure the paths to jsp pages for displaying to user.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class ConfigManager {
    private static final String MAIN = "MAIN";
    private static final String LOGIN = "LOGIN";
    private static final String REGISTRATION = "REGISTRATION";
    private static final String TEST = "TEST";
    private static final String ADMIN = "ADMIN";
    private static final String CONSTRUCTOR = "CONSTRUCTOR";
    private static final String BUNDLE_NAME = "config.config";
    private static final String ERROR = "ERROR503";
    private static ConfigManager instance;
    private ResourceBundle resourceBundle;

    /**
     * Receive value of field {@link ConfigManager#MAIN}
     *
     * @return address of main page
     */
    public static String getMAIN() {
        return MAIN;
    }

    /**
     * Receive value of field {@link ConfigManager#ERROR}
     *
     * @return address of error page
     */
    public static String getERROR() {
        return ERROR;
    }

    /**
     * Receive value of field {@link ConfigManager#LOGIN}
     *
     * @return address of login page
     */
    public static String getLOGIN() {
        return LOGIN;
    }

    /**
     * Receive value of field {@link ConfigManager#REGISTRATION}
     *
     * @return address of registration page
     */
    public static String getREGISTRATION() {
        return REGISTRATION;
    }

    /**
     * Receive value of field {@link ConfigManager#TEST}
     *
     * @return address of quiz page
     */
    public static String getTEST() {
        return TEST;
    }

    /**
     * Receive value of field {@link ConfigManager#ADMIN}
     *
     * @return address of admin page
     */
    public static String getADMIN() {
        return ADMIN;
    }

    /**
     * Receive value of field {@link ConfigManager#CONSTRUCTOR}
     *
     * @return address of quiz constructor page
     */
    public static String getCONSTRUCTOR() {
        return CONSTRUCTOR;
    }

    /**
     * Return or create object of ConfigManager class.
     *
     * @return instance of ConfigManager class.
     */
    public static ConfigManager getInstance(){
        if (instance==null){
            instance = new ConfigManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    /**
     * Get page address from config.properties according to key specified by
     * methods of this class.
     *
     * @param key specify what page should be received
     * @return necessary page address according to received key
     */
    public String getProperty(String key){
        return (String) resourceBundle.getObject(key);
    }
}

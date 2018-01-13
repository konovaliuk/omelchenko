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

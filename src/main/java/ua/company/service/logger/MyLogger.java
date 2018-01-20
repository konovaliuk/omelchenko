package ua.company.service.logger;

import org.apache.log4j.Logger;

/**
 * Logger.java - creates file for writing logs.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 17.12.2017
 */
public class MyLogger extends Logger {

    /**
     * Constructor - creating new object of class {@link MyLogger} with parameter
     *
     * @param name - name
     */
    protected MyLogger(String name) {
        super(name);
    }

    /**
     * Create log4j logger
     *
     * @param cl name of Class
     * @return logger
     */
    public static Logger getLOGGER(Class cl) {
        Logger LOGGER = Logger.getLogger(cl);
        return LOGGER;
    }
}

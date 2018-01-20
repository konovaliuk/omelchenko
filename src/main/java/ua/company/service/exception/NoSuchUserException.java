package ua.company.service.exception;

/**
 * NoSuchUserException.java - custom exception, thrown in situation when user was not find
 *
 * @author Ruslan Omelchenko
 * @version 1.0 18.01.2018
 */
public class NoSuchUserException extends Exception {

    /**
     * Constructor - creation new object of class {@link NoSuchUserException} with parameter
     *
     * @param s - message about exception
     */
    public NoSuchUserException(String s){
        super(s);
    }
}

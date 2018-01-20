package ua.company.service.emailgenerator;

import javax.mail.MessagingException;

/**
 * EmailSender.java - interface for class EmailSenderImpl.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 14.01.2018
 */
public interface EmailSender {
    /**
     * Send e-mail to user who finished quiz
     *
     * @param name login of user
     * @param score the result of passed quiz
     */
    void sendEmail(String name, double score) throws MessagingException;
}

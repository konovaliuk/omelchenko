package ua.company.service.emailgenerator;

import javax.mail.MessagingException;

/**
 * EmailSender.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 14.01.2018
 */
public interface EmailSender {
    void sendEmail(String name, double score) throws MessagingException;
}

package ua.company.service.emailgenerator;

import org.apache.log4j.Logger;
import ua.company.controller.config.AppManager;
import ua.company.service.logger.MyLogger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * EmailSenderImpl.java - class for sending e-mail to users about their result.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 14.01.2018
 */
public class EmailSenderImpl implements EmailSender{
    private static final Logger LOGGER = MyLogger.getLOGGER(EmailSenderImpl.class);
    private static final String subject = "JavaQuiz. Notification about test result.";
    private String emailTo;
    private String message;

    /**
     * Constructor - creation new object of class {@link EmailSender} with parameters
     *
     * @param emailTo e-mail of user where e-mail will be sent
     */
    public EmailSenderImpl(String emailTo) {
        this.emailTo = emailTo;
    }

    /**
     * Send e-mail to user who finished quiz
     *
     * @param name login of user
     * @param score the result of passed quiz
     */
    @Override
    public void sendEmail(String name, double score) throws MessagingException {
        LOGGER.info("Sending email to " + name +"...");

        Authenticator auth = new MyAuthenticator(AppManager.getInstance().getProperty(AppManager.getEmailLogin()),
                AppManager.getInstance().getProperty(AppManager.getEmailPassword()));

        Properties props = System.getProperties();
        props.put("mail.smtp.host", AppManager.getInstance().getProperty(AppManager.getSmtpHost()));
        props.put("mail.smtp.port", AppManager.getInstance().getProperty(AppManager.getSmtpPort()));
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.mime.charset", AppManager.getInstance().getProperty(AppManager.getENCODING()));
        Session session = Session.getDefaultInstance(props, auth);

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(AppManager.getInstance().getProperty(AppManager.getEmailAdress())));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
        msg.setSubject(subject);

        message = "<i>Доброго дня, " + name + "!</i><br><br>" +
                "<i>Ви пройшли тест на сайті JavaQuiz!</i><br><br>" +
                "<i>Бал, що ви набрали: <b>" + score + "</b>.</i><br><br>" +
                "<i>Дякуємо за те, що скористались нашим сервісом.</i><br><br>" +
                "<b><font color=blue>З найкращими побажаннями, команда JavaQuiz </font></b>";

        msg.setContent(message, "text/html; charset=UTF-8");
        Transport.send(msg);
    }

    /**
     * MyAuthenticator.java - class for authentication during sending e-mail to users
     * about their result.
     *
     * @author Ruslan Omelchenko
     * @version 1.0 14.01.2018
     */
    class MyAuthenticator extends Authenticator {
        private String user;
        private String password;

        /**
         * Constructor - creation new object of class {@link MyAuthenticator} with parameters
         *
         * @param user - login for access to mail
         * @param password - password of access to mail
         */
        MyAuthenticator(String user, String password) {
            this.user = user;
            this.password = password;
        }

        /**
         * Get PasswordAuthentication class
         *
         * @return PasswordAuthentication class
         */
        public PasswordAuthentication getPasswordAuthentication() {
            String user = this.user;
            String password = this.password;
            return new PasswordAuthentication(user, password);
        }
    }
}

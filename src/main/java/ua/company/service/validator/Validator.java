package ua.company.service.validator;

import org.apache.log4j.Logger;
import ua.company.controller.config.MessageManager;
import ua.company.service.logger.MyLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Validator.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class Validator {
    private static final Logger LOGGER = MyLogger.getLOGGER(Validator.class);
    private String login;
    private String email;
    private String password;
    private String retypepsw;
    private String country;
    private String gender;

    private List<String> loginMessage;
    private List<String> emailMessage;
    private List<String> passwordMessage;
    private List<String> retypepswMessage;
    private List<String> genderMessage;

    private Locale locale;

    private String regexMail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2," +
            "})$";
    private String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

    public Validator() {
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRetypepsw() {
        return retypepsw;
    }

    public String getCountry() {
        return country;
    }

    public String getGender() {
        return gender;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRetypepsw(String retypepsw) {
        this.retypepsw = retypepsw;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLoginMessage(List<String> loginMessage) {
        this.loginMessage = loginMessage;
    }

    public void setEmailMessage(List<String> emailMessage) {
        this.emailMessage = emailMessage;
    }

    public void setPasswordMessage(List<String> passwordMessage) {
        this.passwordMessage = passwordMessage;
    }

    public void setRetypepswMessage(List<String> retypepswMessage) {
        this.retypepswMessage = retypepswMessage;
    }

    public void setGenderMessage(List<String> genderMessage) {
        this.genderMessage = genderMessage;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public List<String> getEmailMessage() {
        emailMessage = new ArrayList();
        LOGGER.info("Current locale: " + locale);
        if (email.equals("")) {
            if(locale!=null){
                emailMessage.add(MessageManager.getInstance(locale).getProperty(MessageManager.getEmptyEmail()));
            }else {
                emailMessage.add(MessageManager.getInstance().getProperty(MessageManager.getEmptyEmail()));
            }
        }else if (!email.matches(regexMail)) {
            if(locale!=null){
                emailMessage.add(MessageManager.getInstance(locale).getProperty(MessageManager.getInvalidEmail()));
            }else {
                emailMessage.add(MessageManager.getInstance().getProperty(MessageManager.getInvalidEmail()));
            }
        }
        return emailMessage;
    }

    public List<String> getPasswordMessage() {
        passwordMessage = new ArrayList();
        if (!password.matches(regexPassword)) {
            if (locale != null) {
                passwordMessage.add(MessageManager.getInstance(locale).getProperty(MessageManager.getInvalidPassword()));
            } else {
                passwordMessage.add(MessageManager.getInstance().getProperty(MessageManager.getInvalidPassword()));
            }
        }
        return passwordMessage;
    }

    public List<String> getLoginMessage() {
        loginMessage = new ArrayList();
        if (login.equals("")) {
            if (locale != null) {
                loginMessage.add(MessageManager.getInstance(locale).getProperty(MessageManager.getEmptylogin()));
            } else {
                loginMessage.add(MessageManager.getInstance().getProperty(MessageManager.getEmptylogin()));
            }
        }
        return loginMessage;
    }

    public List<String> getGenderMessage() {
        genderMessage = new ArrayList();
        if (gender == null) {
            if (locale != null) {
                genderMessage.add(MessageManager.getInstance(locale).getProperty(MessageManager.getInvalidGender()));
            } else {
                genderMessage.add(MessageManager.getInstance().getProperty(MessageManager.getInvalidGender()));
            }
        }
        return genderMessage;
    }

    public List<String> getRetypepswMessage() {
        retypepswMessage = new ArrayList<String>();
        if (!password.equals(retypepsw)) {
            if (locale != null) {
                retypepswMessage.add(MessageManager.getInstance(locale).
                        getProperty(MessageManager.getInvalidRetypepsw()));
            } else {
                retypepswMessage.add(MessageManager.getInstance().getProperty(MessageManager.getInvalidRetypepsw()));
            }
        }
        return retypepswMessage;
    }

    public boolean isValidLogin() {
        return getLoginMessage().isEmpty()&& getPasswordMessage().isEmpty();
    }

    public boolean isValid() {
        return getLoginMessage().isEmpty()
                && getGenderMessage().isEmpty()
                && getLoginMessage().isEmpty()
                && getPasswordMessage().isEmpty()
                && getRetypepswMessage().isEmpty();
    }
}

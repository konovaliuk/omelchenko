package ua.company.service.validator;

import org.apache.log4j.Logger;
import ua.company.controller.config.MessageManager;
import ua.company.service.logger.MyLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Validator.java - class for validation of data entered by user
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

    /**
     * Constructor - creation new object of class {@link Validator}
     */
    public Validator() {
    }

    /**
     * Receive value of filed {@link Validator#login}
     *
     * @return login of user
     */
    public String getLogin() {
        return login;
    }

    /**
     * Receive value of filed {@link Validator#email}
     *
     * @return email of user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Receive value of filed {@link Validator#password}
     *
     * @return password of user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Receive value of filed {@link Validator#retypepsw}
     *
     * @return retyped password of user
     */
    public String getRetypepsw() {
        return retypepsw;
    }

    /**
     * Receive value of filed {@link Validator#country}
     *
     * @return country inhabitance of user
     */
    public String getCountry() {
        return country;
    }

    /**
     * Receive value of filed {@link Validator#gender}
     *
     * @return gender of user
     */
    public String getGender() {
        return gender;
    }

    /**
     * Define field {@link Validator#login}
     *
     * @param login - login of user
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Define field {@link Validator#email}
     *
     * @param email - email of user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Define field {@link Validator#password}
     *
     * @param password - password of user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Define field {@link Validator#retypepsw}
     *
     * @param retypepsw - retyped password of user
     */
    public void setRetypepsw(String retypepsw) {
        this.retypepsw = retypepsw;
    }

    /**
     * Define field {@link Validator#country}
     *
     * @param country - country of user
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Define field {@link Validator#gender}
     *
     * @param gender - gender of user
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Define field {@link Validator#loginMessage}
     *
     * @param loginMessage - message about login error
     */
    public void setLoginMessage(List<String> loginMessage) {
        this.loginMessage = loginMessage;
    }

    /**
     * Define field {@link Validator#emailMessage}
     *
     * @param emailMessage - message about email error
     */
    public void setEmailMessage(List<String> emailMessage) {
        this.emailMessage = emailMessage;
    }

    /**
     * Define field {@link Validator#passwordMessage}
     *
     * @param passwordMessage - message about password error
     */
    public void setPasswordMessage(List<String> passwordMessage) {
        this.passwordMessage = passwordMessage;
    }


    /**
     * Define field {@link Validator#retypepswMessage}
     *
     * @param retypepswMessage - message about retyped password error
     */
    public void setRetypepswMessage(List<String> retypepswMessage) {
        this.retypepswMessage = retypepswMessage;
    }

    /**
     * Define field {@link Validator#genderMessage}
     *
     * @param genderMessage - message about gender error
     */
    public void setGenderMessage(List<String> genderMessage) {
        this.genderMessage = genderMessage;
    }

    /**
     * Define field {@link Validator#locale}
     *
     * @param locale - required language
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * Receive List of messages concerning errors in email for displaying to user
     *
     * @return List of messages concerning errors in email
     */
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

    /**
     * Receive List of messages concerning errors in password for displaying to user
     *
     * @return List of messages concerning errors in password
     */
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

    /**
     * Receive List of messages concerning errors in login for displaying to user
     *
     * @return List of messages concerning errors in login
     */
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

    /**
     * Receive List of messages concerning absence of gender indicating for displaying to user
     *
     * @return List of messages concerning absence of gender indicating
     */
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

    /**
     * Receive List of messages concerning errors in retyped password for displaying to user
     *
     * @return List of messages concerning errors in retyped password
     */
    public List<String> getRetypepswMessage() {
        retypepswMessage = new ArrayList<>();
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

    /**
     * Validate login of user
     *
     * @return true if login and password are valid and false vice versa
     */
    public boolean isValidLogin() {
        return getLoginMessage().isEmpty()&& getPasswordMessage().isEmpty();
    }

    /**
     * Validate registration of user
     *
     * @return true if all data entered by user are valid and false vice versa
     */
    public boolean isValid() {
        return getLoginMessage().isEmpty()
                && getEmailMessage().isEmpty()
                && getGenderMessage().isEmpty()
                && getLoginMessage().isEmpty()
                && getPasswordMessage().isEmpty()
                && getRetypepswMessage().isEmpty();
    }
}

package ua.company.service.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Validator.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 22.12.2017
 */
public class Validator {
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

    private String regexMail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2," +
            "})$";
    private String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

    public Validator() {
    }

    public Validator(String login, String email, String password, String retypepsw, String country, String gender) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.retypepsw = retypepsw;
        this.country = country;
        this.gender = gender;
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

    public List<String> getEmailMessage() {
        emailMessage = new ArrayList();
        if (email.equals("")) {
            emailMessage.add("Empty e-mail");
        }
        if (!email.matches(regexMail)) {
            emailMessage.add("E-mail is not valid");
        }
        return emailMessage;
    }

    public List<String> getPasswordMessage() {
        passwordMessage = new ArrayList();
        if (!password.matches(regexPassword)) {
            passwordMessage.add("Password must start of string, contain at least one digit, lower case and " +
                    "upper case letter, " +
                    "at least 8 symbols and no whitespace allowed");
        }
        return passwordMessage;
    }

    public List<String> getLoginMessage() {
        loginMessage = new ArrayList();
        if (login.equals("")) {
            loginMessage.add("Empty login");
        }
        return loginMessage;
    }

    public List<String> getGenderMessage() {
        genderMessage = new ArrayList();
        if (gender == null) {
            genderMessage.add("Please, indicate your sex");
        }
        return genderMessage;
    }

    public List<String> getRetypepswMessage() {
        retypepswMessage = new ArrayList<String>();
        if (!password.equals(retypepsw)) {
            retypepswMessage.add("Passwords do not match");
        }
        return retypepswMessage;
    }

    public boolean isValidLogin() {
        return getLoginMessage().isEmpty();
    }

    public boolean isValid() {
        return getLoginMessage().isEmpty()
                && getGenderMessage().isEmpty()
                && getLoginMessage().isEmpty()
                && getPasswordMessage().isEmpty()
                && getRetypepswMessage().isEmpty();
    }
}

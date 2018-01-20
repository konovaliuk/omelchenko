package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * User.java - class for describing entity User.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 12.12.2017
 */
public class User implements Serializable{
    private int id;
    private String login;
    private String email;
    private String password;
    private String retypepsw;
    private String country;
    private String gender;
    private boolean access;
    private int usertypeId;

    /**
     * Constructor for creating new object of entity {@link User}
     */
    public User() {
    }

    /**
     * Receive value of filed {@link User#id}
     *
     * @return id of user
     */
    public long getId() {
        return id;
    }

    /**
     * Define field {@link User#id}
     *
     * @param id - id of user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Receive value of filed {@link User#login}
     *
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define field {@link User#login}
     *
     * @param login - login of user
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Receive value of filed {@link User#email}
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define field {@link User#email}
     *
     * @param email - email of user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Receive value of filed {@link User#password}
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define field {@link User#password}
     *
     * @param password - password of user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Receive value of filed {@link User#retypepsw}
     *
     * @return retypepsw
     */
    public String getRetypepsw() {
        return retypepsw;
    }

    /**
     * Define field {@link User#retypepsw}
     *
     * @param retypepsw - retyped password of user
     */
    public void setRetypepsw(String retypepsw) {
        this.retypepsw = retypepsw;
    }

    /**
     * Receive value of filed {@link User#country}
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Define field {@link User#country}
     *
     * @param country - retyped password of user
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Receive value of filed {@link User#gender}
     *
     * @return gender of user
     */
    public String getGender() {
        return gender;
    }

    /**
     * Define field {@link User#gender}
     *
     * @param gender - gender of user
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Receive value of filed {@link User#access}
     *
     * @return access of user to login
     */
    public boolean isAccess() {
        return access;
    }

    /**
     * Define field {@link User#access}
     *
     * @param access - access of user to login
     */
    public void setAccess(boolean access) {
        this.access = access;
    }

    /**
     * Receive value of filed {@link User#usertypeId}
     *
     * @return user type Id
     */
    public int getUsertypeId() {
        return usertypeId;
    }

    /**
     * Define field {@link User#usertypeId}
     *
     * @param usertypeId - user type Id
     */
    public void setUsertypeId(int usertypeId) {
        this.usertypeId = usertypeId;
    }

    /**
     * Compare two objects by their field {@link User#id}
     *
     * @param o object for comparison
     * @return true if values are equal and false vice versa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id;
    }

    /**
     * Calculate object hash code of this class
     *
     * @return hashcode of object
     */
    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    /**
     * Create string representation of object
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

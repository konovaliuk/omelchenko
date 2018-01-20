package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * UserType.java - class for describing entity UserType.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017

 */
public class UserType implements Serializable{
    private int usertypeId;
    private String usertype;

    /**
     * Constructor for creating new object of entity {@link UserType}
     */
    public UserType() {
    }

    /**
     * Receive value of filed {@link UserType#usertypeId}
     *
     * @return usertype Id
     */
    public int getUsertypeId() {
        return usertypeId;
    }

    /**
     * Define field {@link UserType#usertypeId}
     *
     * @param usertypeId - user type Id
     */
    public void setUsertypeId(int usertypeId) {
        this.usertypeId = usertypeId;
    }

    /**
     * Receive value of filed {@link UserType#usertype}
     *
     * @return user type
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * Define field {@link UserType#usertype}
     *
     * @param usertype - user type
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * Compare two objects by their field {@link UserType#usertypeId}
     *
     * @param o object for comparison
     * @return true if values are equal and false vice versa
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserType userType = (UserType) o;

        return usertypeId == userType.usertypeId;

    }

    /**
     * Calculate object hash code of this class
     *
     * @return hashcode of object
     */
    @Override
    public int hashCode() {
        return (usertypeId ^ (usertypeId >>> 32));
    }

    /**
     * Create string representation of object
     *
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "UserType{" +
                "usertypeId=" + usertypeId +
                ", usertype='" + usertype + '\'' +
                '}';
    }
}

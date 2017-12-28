package ua.company.persistence.domain;

import java.io.Serializable;

/**
 * UserType.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 15.12.2017

 */
public class UserType implements Serializable{
    private int usertypeId;
    private String usertype;

    public UserType() {
    }

    public int getUsertypeId() {
        return usertypeId;
    }

    public void setUsertypeId(int usertypeId) {
        this.usertypeId = usertypeId;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}

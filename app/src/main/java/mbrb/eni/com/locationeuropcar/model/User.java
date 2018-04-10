package mbrb.eni.com.locationeuropcar.model;

import java.util.List;

/**
 * Created by mblandin2016 on 09/04/2018.
 */

public class User {
    private String userId;
    private String agenceId;
    private String mail;
    private String password;

    public User() {
    }

    public User(String userId, String agenceId, String mail, String password) {
        this.userId = userId;
        this.agenceId = agenceId;
        this.mail = mail;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(String agenceId) {
        this.agenceId = agenceId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

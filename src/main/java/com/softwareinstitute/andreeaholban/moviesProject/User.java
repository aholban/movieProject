package com.softwareinstitute.andreeaholban.moviesProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    /////////////////////////////////////////////////Attributes/////////////////////////////////////////////////////////////////
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int user_id;

    private String username;
    private String password;
    private Boolean isAdmin = Boolean.FALSE;

    /////////////////////////////////////////////////Constructors///////////////////////////////////////////////////////////////
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }


    public User(){

    }


    ////////////////////////////////////////////////Methods////////////////////////////////////////////////////////////////////


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String givePrivileges(User toUser){
        String result = "";
        if(this.isAdmin){
            toUser.setAdmin(Boolean.TRUE);
            result = "Privileges successfully set";
        }
        else{
            result = "You cannot give privileges to user";
        }

        return result;
    }
}

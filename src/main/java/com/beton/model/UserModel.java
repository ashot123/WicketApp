package com.beton.model;

import java.io.Serializable;

/**
 * Created by Ashot Karakhanyan on 27-12-2014
 */
public class UserModel implements Serializable {

    private String name;
    private String gender;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

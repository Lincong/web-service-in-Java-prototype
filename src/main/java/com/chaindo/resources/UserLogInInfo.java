package com.chaindo.resources;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
class UserLogInInfo {
    private String username;
    private String password;

    public UserLogInInfo() { // this empty constructor is necessary for Jersey to convert JSON to the object of this class

    }

    public UserLogInInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

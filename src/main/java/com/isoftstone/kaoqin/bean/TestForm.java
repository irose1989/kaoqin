package com.isoftstone.kaoqin.bean;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by wb-chenchaobin on 2015/9/11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestForm {
    private  String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

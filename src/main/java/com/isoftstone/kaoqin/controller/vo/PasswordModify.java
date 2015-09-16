package com.isoftstone.kaoqin.controller.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by wb-chenchaobin on 2015/9/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PasswordModify extends UserVo{
    private String postPwd;
    private String newPwd;

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getPostPwd() {
        return postPwd;
    }

    public void setPostPwd(String postPwd) {
        this.postPwd = postPwd;
    }

    @Override
    public String toString() {
        return "PasswordModify{" +
                "pastPwd='" + postPwd + '\'' +
                ", newPwd='" + newPwd + '\'' +
                '}';
    }

}

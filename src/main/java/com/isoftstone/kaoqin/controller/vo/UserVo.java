package com.isoftstone.kaoqin.controller.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by wb-chenchaobin on 2015/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserVo {
    private String userName;
    private String isoftNo;//员工号
    private String telephone;//手机号
    private int projectNo;//项目组信息
    private String password;//密码

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIsoftNo() {
        return isoftNo;
    }

    public void setIsoftNo(String isoftNo) {
        this.isoftNo = isoftNo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userName='" + userName + '\'' +
                ", isoftNo='" + isoftNo + '\'' +
                ", telephone='" + telephone + '\'' +
                ", projectNo=" + projectNo +
                ", password='" + password + '\'' +
                '}';
    }
}

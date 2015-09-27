package com.isoftstone.kaoqin.controller.vo;

import com.isoftstone.kaoqin.bean.user.User;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by wb-chenchaobin on 2015/9/14.
 */

public class UserVo{
    private Integer userId;

    private String realName;

    private String isoftNo;//员工号

    private String telephone;//手机号

    private Integer projectNo;//项目组信息

    private String projectName;

    private String password;//密码

    private Integer projectId;

    private Integer roleId;//身份 角色id 1，普通 2，管理员，3，项目经理

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public Integer getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Integer projectNo) {
        this.projectNo = projectNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userId=" + userId +
                ", realName='" + realName + '\'' +
                ", isoftNo='" + isoftNo + '\'' +
                ", telephone='" + telephone + '\'' +
                ", projectNo=" + projectNo +
                ", projectName='" + projectName + '\'' +
                ", password='" + password + '\'' +
                ", projectId=" + projectId +
                ", roleId=" + roleId +
                '}';
    }
}

package com.isoftstone.kaoqin.bean.user;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private Integer jobState;

    private String realName;

    private String telephone;

    private String password;

    private Integer roleid;

    private Integer job;

    private Integer professionalSkill;

    private Integer skillLever;

    private String location;

    private String onTheJob;

    private Date hiredate;

    private Date departureDate;

    private Integer projectId;

    private String wangwangNum;

    private String isoftNo;

    private String wbNo;

    private String isoftEmail;

    private String wbEmail;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getJobState() {
        return jobState;
    }

    public void setJobState(Integer jobState) {
        this.jobState = jobState;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public Integer getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(Integer professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

    public Integer getSkillLever() {
        return skillLever;
    }

    public void setSkillLever(Integer skillLever) {
        this.skillLever = skillLever;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getOnTheJob() {
        return onTheJob;
    }

    public void setOnTheJob(String onTheJob) {
        this.onTheJob = onTheJob == null ? null : onTheJob.trim();
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getWangwangNum() {
        return wangwangNum;
    }

    public void setWangwangNum(String wangwangNum) {
        this.wangwangNum = wangwangNum == null ? null : wangwangNum.trim();
    }

    public String getIsoftNo() {
        return isoftNo;
    }

    public void setIsoftNo(String isoftNo) {
        this.isoftNo = isoftNo == null ? null : isoftNo.trim();
    }

    public String getWbNo() {
        return wbNo;
    }

    public void setWbNo(String wbNo) {
        this.wbNo = wbNo == null ? null : wbNo.trim();
    }

    public String getIsoftEmail() {
        return isoftEmail;
    }

    public void setIsoftEmail(String isoftEmail) {
        this.isoftEmail = isoftEmail == null ? null : isoftEmail.trim();
    }

    public String getWbEmail() {
        return wbEmail;
    }

    public void setWbEmail(String wbEmail) {
        this.wbEmail = wbEmail == null ? null : wbEmail.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", jobState=" + jobState +
                ", realName='" + realName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", roleid=" + roleid +
                ", job=" + job +
                ", professionalSkill=" + professionalSkill +
                ", skillLever=" + skillLever +
                ", location='" + location + '\'' +
                ", onTheJob='" + onTheJob + '\'' +
                ", hiredate=" + hiredate +
                ", departureDate=" + departureDate +
                ", projectId=" + projectId +
                ", wangwangNum='" + wangwangNum + '\'' +
                ", isoftNo='" + isoftNo + '\'' +
                ", wbNo='" + wbNo + '\'' +
                ", isoftEmail='" + isoftEmail + '\'' +
                ", wbEmail='" + wbEmail + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
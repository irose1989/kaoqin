package com.isoftstone.kaoqin.bean.record;

import java.util.Date;

public class Record {
    private Integer id;

    private Integer projectId;

    private Integer userId;

    private Date inJob;

    private Date outJob;

    private Date inProject;

    private Date outProject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getInJob() {
        return inJob;
    }

    public void setInJob(Date inJob) {
        this.inJob = inJob;
    }

    public Date getOutJob() {
        return outJob;
    }

    public void setOutJob(Date outJob) {
        this.outJob = outJob;
    }

    public Date getInProject() {
        return inProject;
    }

    public void setInProject(Date inProject) {
        this.inProject = inProject;
    }

    public Date getOutProject() {
        return outProject;
    }

    public void setOutProject(Date outProject) {
        this.outProject = outProject;
    }
}
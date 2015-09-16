package com.isoftstone.kaoqin.controller.vo;

import com.isoftstone.kaoqin.bean.project.Project;
import com.isoftstone.kaoqin.bean.user.User;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by wb-chenchaobin on 2015/9/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttendanceVo {

    private Long id;

    private Date date;

    private Integer userId;

    private Integer workhours;

    private Double overhour;

    private Integer workOff;

    private Integer late;

    private Integer early;

    private Integer absent;

    private Date onDuty;

    private Date offDuty;

    private String description;

    private Project project;

    private User user ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWorkhours() {
        return workhours;
    }

    public void setWorkhours(Integer workhours) {
        this.workhours = workhours;
    }

    public Double getOverhour() {
        return overhour;
    }

    public void setOverhour(Double overhour) {
        this.overhour = overhour;
    }

    public Integer getWorkOff() {
        return workOff;
    }

    public void setWorkOff(Integer workOff) {
        this.workOff = workOff;
    }

    public Integer getLate() {
        return late;
    }

    public void setLate(Integer late) {
        this.late = late;
    }

    public Integer getEarly() {
        return early;
    }

    public void setEarly(Integer early) {
        this.early = early;
    }

    public Integer getAbsent() {
        return absent;
    }

    public void setAbsent(Integer absent) {
        this.absent = absent;
    }

    public Date getOnDuty() {
        return onDuty;
    }

    public void setOnDuty(Date onDuty) {
        this.onDuty = onDuty;
    }

    public Date getOffDuty() {
        return offDuty;
    }

    public void setOffDuty(Date offDuty) {
        this.offDuty = offDuty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AttendanceVo{" +
                "id=" + id +
                ", date=" + date +
                ", userId=" + userId +
                ", workhours=" + workhours +
                ", overhour=" + overhour +
                ", workOff=" + workOff +
                ", late=" + late +
                ", early=" + early +
                ", absent=" + absent +
                ", onDuty=" + onDuty +
                ", offDuty=" + offDuty +
                ", description='" + description + '\'' +
                ", project=" + project +
                ", user=" + user +
                '}';
    }
}

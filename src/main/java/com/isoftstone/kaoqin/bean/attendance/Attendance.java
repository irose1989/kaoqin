package com.isoftstone.kaoqin.bean.attendance;

import java.util.Date;

public class Attendance {
    private Integer id;

    private Date date;

    private Integer userId;

    private Integer workhours;

    private Integer overhour;

    private Integer workOff;

    private Integer late;

    private Integer early;

    private Integer absent;

    private Date onDuty;

    private Date offDuty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getOverhour() {
        return overhour;
    }

    public void setOverhour(Integer overhour) {
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
}
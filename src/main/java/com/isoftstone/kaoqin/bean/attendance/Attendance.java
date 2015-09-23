package com.isoftstone.kaoqin.bean.attendance;

import java.util.Date;

public class Attendance {

    private String day;//("dd格式")

    private String dayFormart;//("yy-mm-dd格式")

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

    private boolean readonly;

    public String getDayFormart() {
        return dayFormart;
    }

    public void setDayFormart(String dayFomart) {
        this.dayFormart = dayFomart;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

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
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "day='" + day + '\'' +
                ", id=" + id +
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
                ", readonly=" + readonly +
                '}';
    }
}
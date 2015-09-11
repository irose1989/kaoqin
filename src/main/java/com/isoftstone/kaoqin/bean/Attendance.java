package com.isoftstone.kaoqin.bean;

import java.sql.Date;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
public class Attendance {
    private int id;
    private Date date;//打卡时间
    private int user_id;//员工编号
    private Date workTime;//正常工作时间
    private String lated;//是否迟到 y：迟到 n:没有
    private String absenteeism;//是否缺勤 y：缺勤 n:没有
    private String qq_reason;//缺勤原因 1，请假2，旷工，3，调休
    private int overtime;//加班时间（小时数）

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public String getLated() {
        return lated;
    }

    public void setLated(String lated) {
        this.lated = lated;
    }

    public String getAbsenteeism() {
        return absenteeism;
    }

    public void setAbsenteeism(String absenteeism) {
        this.absenteeism = absenteeism;
    }

    public String getQq_reason() {
        return qq_reason;
    }

    public void setQq_reason(String qq_reason) {
        this.qq_reason = qq_reason;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", date=" + date +
                ", user_id=" + user_id +
                ", workTime=" + workTime +
                ", lated='" + lated + '\'' +
                ", absenteeism='" + absenteeism + '\'' +
                ", qq_reason='" + qq_reason + '\'' +
                ", overtime=" + overtime +
                '}';
    }
}

package com.isoftstone.kaoqin.controller.vo;

import com.isoftstone.kaoqin.bean.attendance.Attendance;

import java.util.List;

/**
 * Created by Administrator on 2015/9/20.
 */
public class AttendanceVo2 {
    /**每天的考勤记录*/
    private List<Attendance> attendanceList;
    private  String realName;
    private  String projectName;


    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "AttendanceVo2{" +
                "attendanceList=" + attendanceList +
                ", realName='" + realName + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}

package com.isoftstone.kaoqin.controller.vo;

import com.isoftstone.kaoqin.bean.attendance.Attendance;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/21.
 */
public class AttendVo {

    /**封装向前台发送的数据*/

    private  long id;
    /**每天的考勤记录*/
    private List<Attendance> attendanceList;

    private  String realName;

    private  String projectName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

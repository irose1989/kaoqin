package com.isoftstone.kaoqin.controller.vo;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/23.
 */
public class AttendanceVoList {

    /**接收前端发送的数据*/
    private List<AttendanceVo>attendanceVoList;

    public List<AttendanceVo> getAttendanceVoList() {
        return attendanceVoList;
    }

    public void setAttendanceVoList(List<AttendanceVo> attendanceVoList) {
        this.attendanceVoList = attendanceVoList;
    }

    @Override
    public String toString() {
        return "AttendanceVoList{" +
                "attendanceVoList=" + attendanceVoList +
                '}';
    }
}

package com.isoftstone.kaoqin.dao.attendanceMapper;

import com.isoftstone.kaoqin.bean.attendance.Attendance;
import com.isoftstone.kaoqin.controller.vo.AttendVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo;

import java.util.List;
import java.util.Map;

public interface AttendanceMapperExt extends AttendanceMapper{
    /**获取所有的考勤记录*/
    List<AttendVo> getAll(Map map);
    /**插入一个月的考勤表*/
    int insertMonth(List<Attendance> userList);
    /**保存考勤数据*/
    int saveRecord(AttendanceVo vo);
    int saveRecords(List<AttendanceVo> list);
}
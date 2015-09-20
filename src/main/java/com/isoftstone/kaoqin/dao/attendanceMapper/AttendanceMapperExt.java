package com.isoftstone.kaoqin.dao.attendanceMapper;

import com.isoftstone.kaoqin.controller.vo.AttendanceVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo2;

import java.util.List;
import java.util.Map;

public interface AttendanceMapperExt extends AttendanceMapper{
    public  List<AttendanceVo> selectAll(Map map);
    public  List<AttendanceVo2> select(Map map);

}
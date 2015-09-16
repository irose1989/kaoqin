package com.isoftstone.kaoqin.dao.attendanceMapper;

import com.isoftstone.kaoqin.controller.vo.AttendanceVo;

import java.util.List;
import java.util.Map;

public interface AttendanceMapperExt extends AttendanceMapper{
    List<AttendanceVo> selectAll(Map map);
}
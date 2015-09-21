package com.isoftstone.kaoqin.dao.attendanceMapper;

import com.isoftstone.kaoqin.controller.vo.AttendVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo;

import java.util.List;
import java.util.Map;

public interface AttendanceMapperExt extends AttendanceMapper{
    public  List<AttendanceVo> selectAll(Map map);
    public  List<AttendVo> getAll(Map map);

}
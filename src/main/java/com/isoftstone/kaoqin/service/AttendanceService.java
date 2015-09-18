package com.isoftstone.kaoqin.service;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.controller.vo.AttendanceDateVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public interface AttendanceService {
    /**查找考勤多有记录*/
    BasicAttendance<List<AttendanceVo>> findAll(int currentPage,AttendanceDateVo dateVo);
}

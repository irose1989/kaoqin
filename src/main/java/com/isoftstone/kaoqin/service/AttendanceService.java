package com.isoftstone.kaoqin.service;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.utils.PageConf;
import com.isoftstone.kaoqin.controller.vo.AttendVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceDateVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceVoList;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public interface AttendanceService {
    /**查找考勤多有记录*/
    public BasicAttendance findAll(PageConf pageConf, AttendanceDateVo dateVo);
    /**导出excel 不用分页*/
    public BasicAttendance findAll( AttendanceDateVo dateVo);
    public BasicAttendance batchCreateAttendanceRecord(List<User> userList);
    public BasicAttendance savaAttendanceRecord(AttendanceVoList voList);
}

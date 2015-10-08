package com.isoftstone.kaoqin.service;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.utils.PageConf;
import com.isoftstone.kaoqin.controller.vo.*;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public interface AttendanceService {
    /**查找考勤多有记录*/
    public BasicAttendance findAll(PageConf pageConf, AttendanceDateVo dateVo);
    /**导出excel 不用分页*/
    public BasicAttendance findAll( AttendanceDateVo dateVo);
    /**根据条件 查看考勤记录*/
    public BasicAttendance findByCondition(SearchConditions conditions);
    public BasicAttendance batchCreateAttendanceRecord(List<User> userList);
    public BasicAttendance savaAttendanceRecord(AttendanceVoList voList);

}

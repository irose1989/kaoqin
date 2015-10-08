package com.isoftstone.kaoqin.utils;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.service.AttendanceService;
import com.isoftstone.kaoqin.service.UserService;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;


/**
 * Created by wb-chenchaobin on 2015/10/8.
 */
public class TimerTaskerUtil extends QuartzJobBean {
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    UserService userService;
    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }

    public void getTest(){
        System.out.println("=====执行TimerTask定时成功=====");
        BasicAttendance basicAttendance = userService.findAllUser();
        List<User> userList = (List<User>) basicAttendance.getData();
        attendanceService.batchCreateAttendanceRecord(userList);
    }


}

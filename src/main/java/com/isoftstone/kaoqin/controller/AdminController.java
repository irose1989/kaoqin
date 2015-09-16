package com.isoftstone.kaoqin.controller;

import com.isoftstone.kaoqin.bean.attendance.Attendance;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.utils.DateFormat;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo;
import com.isoftstone.kaoqin.controller.vo.PageVo;
import com.isoftstone.kaoqin.controller.vo.UserVo;
import com.isoftstone.kaoqin.controller.vo.UserVoList;
import com.isoftstone.kaoqin.service.AttendanceService;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by wb-chenchaobin on 2015/9/14.
 */
@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private AttendanceService attendanceService;

    /**
     * 开通一个账号
     * */
    @RequestMapping(value ="/openAccount.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance openAccount(@RequestBody UserVo vo){
        BasicAttendance basicAttendance= userService.openAccount(vo);
        return basicAttendance;
    }

    /**批量开通账号*/
    @RequestMapping(value = "/batchOpenAccount.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance batchOpenAccount(@RequestBody UserVoList userVoList){
        BasicAttendance basicAttendance = userService.batchOpenAccount(userVoList);
        return basicAttendance;
    }

    /**查找所有考勤记录*/
    @RequestMapping(value = "/findAttendance2.do",method = RequestMethod.POST)
    //@ResponseBody
    public String findAttendance
    (@RequestBody PageVo pageVo,HttpServletRequest request){
        /*测试pageVo.getCurrentPage()*/
        BasicAttendance<List<AttendanceVo>> basicAttendance
                =attendanceService.findAll(1);
        request.setAttribute("list",basicAttendance.getData());

        List<String>month = DateFormat.getDateList();
        request.setAttribute("month",month);
        return "attendence";
    }

    /**测试查找所有考勤记录*/
    @RequestMapping(value = "/findAttendance.do",method = RequestMethod.GET)
    public String findAttendance2
    ( int currentPage,HttpServletRequest request){
        /*测试pageVo.getCurrentPage()*/
        BasicAttendance<List<AttendanceVo>> basicAttendance
                =attendanceService.findAll(currentPage);
        request.setAttribute("list",basicAttendance.getData());

        List<String>month = DateFormat.getDateList();
        request.setAttribute("month",month);
        return "attendence";
    }
    /**登记考勤*/
}

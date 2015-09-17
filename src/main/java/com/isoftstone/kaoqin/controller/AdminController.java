package com.isoftstone.kaoqin.controller;

import antlr.StringUtils;
import com.isoftstone.kaoqin.bean.attendance.Attendance;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.utils.DateFormat;
import com.isoftstone.kaoqin.controller.vo.*;
import com.isoftstone.kaoqin.service.AttendanceService;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        AttendanceDateVo dateVo = DateFormat.getDateList(0);
        request.setAttribute("month",dateVo);
        return "attendence";
    }

    /**测试查找所有考勤记录*/
    @RequestMapping(value = "/findAttendance.do",method = RequestMethod.GET)
    public String findAttendance2
    ( int currentPage,HttpServletRequest request){
        /*测试pageVo.getCurrentPage()*/
        BasicAttendance<List<AttendanceVo>> basicAttendance
                =attendanceService.findAll(currentPage);





        /**测试时间*/
        List<AttendanceVo> listVo = basicAttendance.getData();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String test = "2015-09-16";
        for(AttendanceVo vo :listVo){
            Date date =vo.getDate();
            String s =format.format(date);
            if(com.alibaba.druid.util.StringUtils.equals(s,test)){
                System.out.println(1);
            }
        }




        request.setAttribute("list",basicAttendance.getData());
        AttendanceDateVo dateVo = DateFormat.getDateList(0);
        request.setAttribute("month",dateVo);
        return "attendence";
    }

    /**考勤页面上下旬*/
    @RequestMapping(value = "/changeDay",method = RequestMethod.GET)
    @ResponseBody
    public BasicAttendance changeDay(HttpServletRequest request){
        BasicAttendance basicAttendance = new BasicAttendance();
        int upOrDown = Integer.parseInt(request.getParameter("upOrDown"));
        AttendanceDateVo dateVo = DateFormat.getDateList(upOrDown);
        basicAttendance.setData(dateVo);
            return basicAttendance;
    }

    /**登记考勤*/
}

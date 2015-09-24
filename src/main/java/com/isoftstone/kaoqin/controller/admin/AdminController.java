package com.isoftstone.kaoqin.controller.admin;

import antlr.StringUtils;
import com.isoftstone.kaoqin.bean.attendance.Attendance;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.BasicConstants;
import com.isoftstone.kaoqin.common.utils.CreateExcelToDisk;
import com.isoftstone.kaoqin.common.utils.DateFormat;
import com.isoftstone.kaoqin.common.utils.PageConf;
import com.isoftstone.kaoqin.controller.vo.*;
import com.isoftstone.kaoqin.service.AttendanceService;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    /**开通账号*/
    @RequestMapping(value = "/openAccount.do" ,method = RequestMethod.GET)
    public String openAccount(){
        return "createAccount";
    }
    /**
     * 开通一个账号
     * */
   /* @RequestMapping(value ="/openAccount.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance openAccount(@RequestBody UserVo vo){
        BasicAttendance basicAttendance= userService.openAccount(vo);
        return basicAttendance;
    }*/
    /**检查账号是否已经开通*/
    @ResponseBody
    @RequestMapping(value = "/checkUser",method = RequestMethod.GET)
    public BasicAttendance checkUser(String isoftNo){
        BasicAttendance basicAttendance = userService.checkUserExist(isoftNo);
        return basicAttendance;
    }

    /**批量开通账号*/
    @RequestMapping(value = "/batchOpenAccount.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance batchOpenAccount(@RequestBody UserVoList userVoList){
        BasicAttendance basicAttendance = userService.batchOpenAccount(userVoList);
        return basicAttendance;
    }

    /**测试 查找所有考勤记录*/
    @RequestMapping(value = "/findAttendance2.do",method = RequestMethod.POST)
    public String findAttendance
    (@RequestBody PageVo pageVo,HttpServletRequest request){
        /*测试pageVo.getCurrentPage()*/
        PageConf pageConf = new PageConf();
        pageConf.setCurrentPage(BasicConstants.DEFAULT_CURRENT_PAGE);
        BasicAttendance<List<AttendVo>> basicAttendance
                =attendanceService.findAll(pageConf,null);
        request.setAttribute("list",basicAttendance.getData());

        AttendanceDateVo dateVo = DateFormat.getDateList();
        request.setAttribute("month",dateVo);
        return "attendence";
    }

    /**登录默认展现页面 或者点击考勤查询 默认当前一整个月*/
    @RequestMapping(value = "/findAttendance.do",method = RequestMethod.GET)
    public String findAttendance2(HttpServletRequest request){
        /**封装整个月考勤时间段，考勤时间集(前台显示横坐标)*/
        AttendanceDateVo dateVo = DateFormat.getDateList();
        /**默认第一页*/
        PageConf pageConf = new PageConf();
        pageConf.setCurrentPage(BasicConstants.DEFAULT_CURRENT_PAGE);
        BasicAttendance basicAttendance
                =attendanceService.findAll(pageConf, dateVo);
        /**给date转换只有天数的格式 考勤上的时间（跟横坐标日期比较）*/
        basicAttendance = DateFormat.getDateToDay(basicAttendance);
        request.setAttribute("list", basicAttendance.getData());
        request.setAttribute("page",basicAttendance.getPageConf());
        request.setAttribute("month",dateVo);
        return "attendence";
    }

    /*考勤页面上下旬---现在默认一个月*/
    @RequestMapping(value = "/changeDay",method = RequestMethod.GET)
    @ResponseBody
    public BasicAttendance changeDay(HttpServletRequest request){
       /* BasicAttendance basicAttendance = new BasicAttendance();*/

        /*AttendanceDateVo dateVo = DateFormat.getDateList(upOrDown);
        basicAttendance.setData(dateVo);
            return basicAttendance;*/
        int upOrDown = Integer.parseInt(request.getParameter("upOrDown"));
        AttendanceDateVo dateVo = DateFormat.getDateList();
        /**默认第一页 List<AttendanceVo>*/
        PageConf pageConf = new PageConf();
        pageConf.setCurrentPage(BasicConstants.DEFAULT_CURRENT_PAGE);
        BasicAttendance basicAttendance
                =attendanceService.findAll(pageConf, dateVo);
        /**给date转换只有天数的格式*/
        basicAttendance = DateFormat.getDateToDay(basicAttendance);
    /*    request.setAttribute("list",basicAttendance.getData());
        request.setAttribute("month",dateVo);*/
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("month", dateVo);
        map.put("listAttend", basicAttendance.getData());
        basicAttendance.setData(map);
        return basicAttendance;
    }
    /**登记考勤*/
    @RequestMapping(value = "/saveAttendance.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance saveAttendance(@RequestBody AttendanceVoList attendanceVoList){
        BasicAttendance basicAttendance = attendanceService.savaAttendanceRecord(attendanceVoList);
        return basicAttendance;
    }
    /**导出excel表格*/
    @RequestMapping(value = "/createExcel.do",method = RequestMethod.GET)
    @ResponseBody
    public BasicAttendance createExcel()throws  Exception{
        /**封装整个月考勤时间段，考勤时间集(前台显示横坐标)*/
        AttendanceDateVo dateVo = DateFormat.getDateList();
        /**默认第一页*/
        PageConf pageConf = new PageConf();
        pageConf.setCurrentPage(BasicConstants.DEFAULT_CURRENT_PAGE);
        BasicAttendance<List<AttendVo>> basicAttendance
                =attendanceService.findAll(dateVo);
        /**给date转换只有天数的格式 考勤上的时间（跟横坐标日期比较）*/
        basicAttendance = DateFormat.getDateToDay(basicAttendance);
        basicAttendance = CreateExcelToDisk.getExcel(basicAttendance.getData(),dateVo);
        return basicAttendance;
    }
    /**分页*/
    @RequestMapping(value = "/page.do",method = RequestMethod.POST)
    public String getPage(HttpServletRequest request,@RequestBody PageConf pageConf){
        /**封装整个月考勤时间段，考勤时间集(前台显示横坐标)*/
        AttendanceDateVo dateVo = DateFormat.getDateList();
        /**分页*/
        BasicAttendance basicAttendance
                =attendanceService.findAll(pageConf, dateVo);
        /**给date转换只有天数的格式 考勤上的时间（跟横坐标日期比较）*/
        basicAttendance = DateFormat.getDateToDay(basicAttendance);
        request.setAttribute("list",basicAttendance.getData());
        request.setAttribute("page",basicAttendance.getPageConf());
        request.setAttribute("month",dateVo);
        return "attendence";
    }

    /**分页*/
    @RequestMapping(value = "/getPage.do",method = RequestMethod.GET)
    public String getOtherPage(HttpServletRequest request,int currentPage){
        PageConf pageConf = new PageConf();
        pageConf.setCurrentPage(currentPage);
        /**封装整个月考勤时间段，考勤时间集(前台显示横坐标)*/
        AttendanceDateVo dateVo = DateFormat.getDateList();
        /**分页*/
        BasicAttendance basicAttendance
                =attendanceService.findAll(pageConf, dateVo);
        /**给date转换只有天数的格式 考勤上的时间（跟横坐标日期比较）*/
        basicAttendance = DateFormat.getDateToDay(basicAttendance);
        request.setAttribute("list",basicAttendance.getData());
        request.setAttribute("page",basicAttendance.getPageConf());
        request.setAttribute("month",dateVo);
        return "attendence";
    }
}

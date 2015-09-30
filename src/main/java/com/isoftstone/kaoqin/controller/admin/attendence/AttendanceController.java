package com.isoftstone.kaoqin.controller.admin.attendence;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.BasicConstants;
import com.isoftstone.kaoqin.common.utils.CreateExcelToDisk;
import com.isoftstone.kaoqin.common.utils.DateFormat;
import com.isoftstone.kaoqin.common.utils.PageConf;
import com.isoftstone.kaoqin.controller.vo.AttendVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceDateVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceVoList;
import com.isoftstone.kaoqin.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 考情页面相关
 * Created by wb-chenchaobin on 2015/9/16.
 */
@Controller
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("/getDate.do")
    public String getAttendanceDate(@RequestBody AttendanceDateVo dateVo){
        return null;
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
        basicAttendance = CreateExcelToDisk.getExcel(basicAttendance.getData(), dateVo);
        return basicAttendance;
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

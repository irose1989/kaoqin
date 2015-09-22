package com.isoftstone.kaoqin.service.impl;

import com.isoftstone.kaoqin.bean.attendance.Attendance;
import com.isoftstone.kaoqin.bean.attendance.AttendanceExample;
import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.AttendanceConstants;
import com.isoftstone.kaoqin.common.constants.BasicConstants;
import com.isoftstone.kaoqin.common.utils.DateFormat;
import com.isoftstone.kaoqin.common.utils.PageUtil;
import com.isoftstone.kaoqin.controller.vo.AttendVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceDateVo;
import com.isoftstone.kaoqin.dao.attendanceMapper.AttendanceMapperExt;
import com.isoftstone.kaoqin.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private  AttendanceMapperExt admExt;
    /**分页查询考勤记录*/
    public BasicAttendance<List<AttendVo>> findAll(int currentPage, AttendanceDateVo dateVo) {
        /**考勤时间段条件*/
        String from = dateVo.getFrom();
        String to = dateVo.getTo();
        /**分页查询条件*/
        int page = currentPage-1;
        int size = BasicConstants.PAGESIZE;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("limit",-1);
        map.put("size", size);
        map.put("from",from);
        map.put("to",to);

        List<AttendVo>voList = admExt.getAll(map);
         voList = PageUtil.getPageList(voList,page*size,size);
        /**最近一周才能修改*/
        voList = DateFormat.getReadOnly(voList);

        int totalResults=voList.size();
        return PageUtil.getPage(voList,totalResults,page);
    }

    public int getCounts(Map map){
        /*Map<String,Integer> map = new HashMap<String, Integer>();*/
        /**limit设为-1，即查找所有*/
        map.put("limit",-1);
        map.put("size", BasicConstants.PAGESIZE);
        List<AttendVo>voList = admExt.getAll(map);
        if(CollectionUtils.isEmpty(voList)){
            return 0;
        }
        else return  voList.size();
    }

    public BasicAttendance<Attendance> batchCreateAttendanceRecord(List<User> userList) {
        BasicAttendance<Attendance> basicAttendance = new BasicAttendance<Attendance>();
        if(CollectionUtils.isEmpty(userList)){
            basicAttendance.setCode(AttendanceConstants.createAttendFailedCode);
            basicAttendance.setMsg(AttendanceConstants.createAttendFailedMsg);
            return basicAttendance;
        }
        List<Date> dateList = DateFormat.getDaoDateList();
        List<Integer> resultList = new ArrayList<Integer>();

        for(User u:userList){
            int code = 0 ;
            int userId = u.getId();
            List<Attendance> attendanceList = new ArrayList<Attendance>();
            for(Date d:dateList){
                Attendance attendance = new Attendance();
                attendance.setUserId(userId);
                attendance.setDate(d);
                attendanceList.add(attendance);
            }
            int result = admExt.insertMonth(attendanceList);
            if(result==dateList.size()){
                code = AttendanceConstants.createAttendSuccessCode;
                resultList.add(code);
            }
        }
        if(userList.size() == resultList.size()){
            basicAttendance.setCode(AttendanceConstants.createAttendSuccessCode);
            basicAttendance.setMsg(AttendanceConstants.createAttendSuccessMsg);
        }
        basicAttendance.setCode(AttendanceConstants.createAttendFailedCode);
        basicAttendance.setMsg(AttendanceConstants.createAttendFailedMsg);
        return basicAttendance;
    }
}

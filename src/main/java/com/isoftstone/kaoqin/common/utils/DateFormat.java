package com.isoftstone.kaoqin.common.utils;

import com.isoftstone.kaoqin.bean.attendance.Attendance;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.AttendanceConstants;
import com.isoftstone.kaoqin.controller.vo.AttendVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceDateVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class DateFormat {

    /**根据获取整个 考勤日期表*/
    public static AttendanceDateVo getDateList(){
        AttendanceDateVo vo = new AttendanceDateVo();
        List<String> list = new ArrayList<String>();
        /**自动获取登入的当天时间*/
        Date d = new Date();
        int today = d.getDate();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        SimpleDateFormat format = new SimpleDateFormat("dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        int totalDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= totalDays; i++) {
            c.set(Calendar.DAY_OF_MONTH, i);
            Date date = c.getTime();
            String s = format.format(date);
            list.add(s);

            /**设置整个月 考勤区间*/
            if(i==1){
                String from = format2.format(getFirstDay(c)) ;
                vo.setFrom(from);
            }
            if(i==totalDays){
                String to = format2.format(getLastDay(c)) ;
                vo.setTo(to);
            }
        }
        vo.setDateList(list);
        return vo;
        /*if(upOrDown == AttendanceConstants.UPMONTH){
            for (int i = 1; i <= 15; i++) {
                c.set(Calendar.DAY_OF_MONTH, i);
                Date date = c.getTime();
                String s = format.format(date);
                list.add(s);

                *//**设置上旬的区间*//*
                if(i==1){
                    String from = format2.format(date) ;
                    vo.setFrom(from);
                }
                if(i==15){
                    String to = format2.format(date) ;
                    vo.setTo(to);
                }
            }

            vo.setDateList(list);
        }else {
            for (int i = 16; i <= totalDays; i++) {
                c.set(Calendar.DAY_OF_MONTH, i);
                Date date = c.getTime();
                String s = format.format(date);
                list.add(s);

                *//**设置下旬的区间*//*
                if(i==16){
                    String from = format2.format(date) ;
                    vo.setFrom(from);
                }
                if(i==totalDays){
                    String to = format2.format(date) ;
                    vo.setTo(to);
                }
            }
            vo.setDateList(list);
        }*/

    }

    /**获取readonly*/
    public static List<AttendVo> getReadOnly(List<AttendVo> voList){
        Date d = new Date();
        long today = d.getTime();
        for(AttendVo vo:voList){
            List<Attendance> attList = vo.getAttendanceList();
            if(CollectionUtils.isEmpty(attList)){
                return null;
            }
            for(Attendance attendance:attList){

                long day = attendance.getDate().getTime();
                if(today-day>=0 && today-day<=AttendanceConstants.WEEK){
                    attendance.setReadonly(false);
                }else{
                    attendance.setReadonly(true);
                }
            }
        }
        return voList;
    }

    /**设置月初时间 0时0分0秒*/
    public static Date getFirstDay(Calendar c){
        /**获取1号 0时0分的时间点*/
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    /**设置月末时间 23时59分59秒*/
    public static Date getLastDay(Calendar c){
        /**获取1号 0时0分的时间点*/
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        c.set(Calendar.MINUTE, 59);
        //将秒至0
        c.set(Calendar.SECOND,59);
        //将毫秒至0
       // c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    /**根据数据库的date 转换成 只有天数*/
    public static BasicAttendance<List<AttendVo>> getDateToDay(BasicAttendance<List<AttendVo>> basicAttendance){
        List<AttendVo> list = basicAttendance.getData();
        SimpleDateFormat format = new SimpleDateFormat("dd");
        for(AttendVo vo:list){
            List<Attendance> attList = vo.getAttendanceList();
            if(CollectionUtils.isEmpty(attList)){
                return null;
            }
            for(Attendance attendance:attList){
                Date date = attendance.getDate();
                String day = format.format(date);
                attendance.setDay(day);
            }
        }
        basicAttendance.setData(list);
        return  basicAttendance;
    }



}

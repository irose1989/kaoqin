package com.isoftstone.kaoqin.common.utils;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.AttendanceConstants;
import com.isoftstone.kaoqin.controller.vo.AttendanceDateVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class DateFormat {

    /**根据上下月份获取 考勤日期表*/
    public static AttendanceDateVo getDateList(int upOrDown){
        AttendanceDateVo vo = new AttendanceDateVo();
        List<String> list = new ArrayList<String>();
        /**自动获取登入的当天时间*/
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        SimpleDateFormat format = new SimpleDateFormat("dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        int totalDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        if(upOrDown == AttendanceConstants.UPMONTH){
            for (int i = 1; i <= 15; i++) {
                c.set(Calendar.DAY_OF_MONTH, i);
                Date date = c.getTime();
                String s = format.format(date);
                list.add(s);

                /**设置上旬的区间*/
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

                /**设置下旬的区间*/
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
        }
        return vo;
    }


    /**刚进 员工考勤页面 根据系统时间区分上下旬*/
    public static int getDateList(){
        List<String> list = new ArrayList<String>();
        /**获取登入的当天时间点*/
        Date d = new Date();
        long now = d.getTime();
        /**获取16号 0时0分的时间点*/
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.set(Calendar.DAY_OF_MONTH, 16);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND,0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        long mid = c.getTime().getTime();

        int upAndDown =0;
        /**上旬*/
        if(now-mid<0){
            upAndDown =1;
        }
        /**下旬*/
        if(now-mid>=0){
            upAndDown = 2;
        }
        return upAndDown;
    }

    /**根据数据库的date 转换成 只有天数*/
    public static BasicAttendance<List<AttendanceVo>> getDateToDay(BasicAttendance<List<AttendanceVo>> basicAttendance){
        List<AttendanceVo> list = basicAttendance.getData();
        SimpleDateFormat format = new SimpleDateFormat("dd");
        for(AttendanceVo vo:list){
            Date date = vo.getDate();
            String day = format.format(date);
            vo.setDay(day);
        }
        basicAttendance.setData(list);
        return  basicAttendance;
    }



}

package com.isoftstone.kaoqin.common.utils;

import com.isoftstone.kaoqin.bean.attendance.Attendance;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.AttendanceConstants;
import com.isoftstone.kaoqin.controller.vo.AttendVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceDateVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo;
import com.isoftstone.kaoqin.controller.vo.SearchConditions;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class DateFormat {
    /**节假日*/
    private static List<String>holidays;
    static {
    }

    /**客户端 根据系统时间获取当前月份整个 考勤日期表*/
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

    }
    /**客户端 根据指定月份获取当前月份整个 考勤日期表*/
    public static AttendanceDateVo getDateList(SearchConditions conditions){
        AttendanceDateVo vo = new AttendanceDateVo();
        List<String> list = new ArrayList<String>();
        /**自动获取登入的当天时间*/
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,conditions.getYear());
        c.set(Calendar.MONTH, conditions.getMonth() - 1);//Java月份才0开始算
        int totalDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat format = new SimpleDateFormat("dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
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

    }

    /**dao层 根据系统时间获取整个月 考勤日期表*/
    public static List<Date> getDaoDateList(){
        List<Date> dateList = new ArrayList<Date>();
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int totalDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        for(int i =1;i<=totalDays;i++){
            c.set(Calendar.DAY_OF_MONTH,i);
            Date date = c.getTime();
            dateList.add(date);
        }
        return dateList;
    }

    /**获取readonly 最近15天*/
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
                if(today-day>=0 && today-day<=AttendanceConstants.TWOWEEK){
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
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        for(AttendVo vo:list){
            List<Attendance> attList = vo.getAttendanceList();
            if(CollectionUtils.isEmpty(attList)){
                return null;
            }
            for(Attendance attendance:attList){
                Date date = attendance.getDate();
                String day = format.format(date);
                String dayFormart = format2.format(date);
                attendance.setDay(day);
                attendance.setDayFormart(dayFormart);
            }
        }
        basicAttendance.setData(list);
        return  basicAttendance;
    }
    /**根据月份获取第一天跟最后一天*/
    public static  BasicAttendance getFromAndTo(SearchConditions searchConditions){
        int month = searchConditions.getMonth();
        int year = searchConditions.getYear();
        BasicAttendance basicAttendance = new BasicAttendance();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH, month - 1);//Java月份才0开始算
        int totalDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        String from = year+"-"+month+"-01";
        String to = year+"-"+month+"-"+totalDays;
        searchConditions.setFrom(from);
        searchConditions.setTo(to);
        basicAttendance.setData(searchConditions);
        return basicAttendance;
    }

    /**是否是法定节假日*/
    public static boolean isHoliday(String date){

        return false;
    }

    /**是否是周末*/
    public static boolean isWeekend(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date day = format.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(day);
            int weekday = cal.get(Calendar.DAY_OF_WEEK);
            if(weekday == 7 || weekday == 1){
                return true;
            }else{
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }



}

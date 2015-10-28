package com.isoftstone.kaoqin.common.utils;

import com.isoftstone.kaoqin.bean.attendance.Attendance;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.controller.vo.SearchConditions;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class DateTest {
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        Date d = new Date();
        long now = d.getTime();
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
        if(mid-now<0){
            System.out.print(now);
        }
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        int totalDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= totalDays; i++) {
            c.set(Calendar.DAY_OF_MONTH, i);
            Date date = c.getTime();
            String s = format.format(date);
            list.add(s);

        }
        for(String da:list){
            System.out.println(da.toString());
        }
    }
    @Test
    public void test2(){
        Date date = new Date();
        long l =date.getTime();
        System.out.print(l);
    }
    @Test
    public void  test3(){
        int year = 2015;
        int month = 9;
        SearchConditions conditions = new SearchConditions();
        conditions.setMonth(month);
        conditions.setYear(year);
        BasicAttendance basicAttendance = DateFormat.getFromAndTo(conditions);
        System.out.print(basicAttendance);
    }
    /**周末测试*/
    @Test
    public void test4(){
        String day = "2015-10-17";
        boolean isWeekend = DateFormat.isWeekend(day);
        System.out.print(isWeekend);
    }
}

package com.isoftstone.kaoqin.common.utils;

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
    public static AttendanceDateVo getDateList(){
        AttendanceDateVo vo = new AttendanceDateVo();

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        SimpleDateFormat format = new SimpleDateFormat("dd");
        int totalDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= totalDays; i++) {

            c.set(Calendar.DAY_OF_MONTH, i);
            Date date = c.getTime();
            String s = format.format(date);
            if(i<=15){
                list1.add(s);
            }else{
                list2.add(s);
            }
        }
        vo.setUpDateList(list1);
        vo.setDownDateList(list2);
        return vo;
    }
}

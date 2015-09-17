package com.isoftstone.kaoqin.common.utils;

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
    public static AttendanceDateVo getDateList(int upOrDown){
        AttendanceDateVo vo = new AttendanceDateVo();
        List<String> list = new ArrayList<String>();
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        SimpleDateFormat format = new SimpleDateFormat("dd");
        int totalDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        if(upOrDown == AttendanceConstants.UPMONTH){
            for (int i = 1; i <= 15; i++) {
                c.set(Calendar.DAY_OF_MONTH, i);
                Date date = c.getTime();
                String s = format.format(date);
                list.add(s);
            }
            vo.setDateList(list);
        }else {
            for (int i = 16; i <= totalDays; i++) {
                c.set(Calendar.DAY_OF_MONTH, i);
                Date date = c.getTime();
                String s = format.format(date);
                list.add(s);
            }
            vo.setDateList(list);
        }
        return vo;
    }
}

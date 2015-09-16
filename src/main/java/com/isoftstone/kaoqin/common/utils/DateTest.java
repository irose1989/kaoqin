package com.isoftstone.kaoqin.common.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class DateTest {
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
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
}

package com.isoftstone.kaoqin.dao.attendanceMapper.test;

import com.isoftstone.kaoqin.bean.attendance.Attendance;
import com.isoftstone.kaoqin.common.utils.DateFormat;
import com.isoftstone.kaoqin.controller.vo.AttendVo;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo;
import com.isoftstone.kaoqin.dao.attendanceMapper.AttendanceMapperExt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wb-chenchaobin on 2015/9/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring_mybatis.xml" })
public class AttendanceMapperExtTest {

    @Autowired
    private AttendanceMapperExt ext;

    @Test
    public void test1(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("limit",0);
        map.put("size", 10);
        String to = "2015-09-30";
        String from = "2015-09-1";
        map.put("from",from);
        map.put("to",to);
        List<AttendVo>list =  ext.getAll(map);
        System.out.println("====================="+list.size());
        for(AttendVo vo :list){
            System.out.println(vo);
        }
    }

    @Test
    public void test2(){
        int id = 55;
        Date date = new Date();
        long d = date.getTime()-1000*60*60*24;
        Date date1 = new Date(d);
        System.out.println(date);
        System.out.println(date1);
        Attendance a1 = new Attendance();
        Attendance a2 = new Attendance();
        a1.setUserId(id);
        a1.setDate(date);
        a2.setUserId(id);
        a2.setDate(date1);
        List<Attendance> list = new ArrayList<Attendance>();
        list.add(a1);
        list.add(a2);
        int n =ext.insertMonth(list);
        System.out.println("==========================" + n);
    }
    @Test
    public void test4(){
        List<Attendance> list = new ArrayList<Attendance>();
        int id =66;
        List<Date>dateList=DateFormat.getDaoDateList();
        for (Date d:dateList){
            Attendance a = new Attendance();
            a.setUserId(id);
            a.setDate(d);
            list.add(a);
        }
        int n = ext.insertMonth(list);
        System.out.println("==========================" + n);
    }


    @Test
    public void test3(){
        List<Date> list = DateFormat.getDaoDateList();
        for (Date d:list){
            System.out.println(d);
        }
    }

    @Test
    public void test5(){
        List<AttendanceVo>list = new ArrayList<AttendanceVo>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate1 = "2015-09-23";
        String strDate2 = "2015-09-22";
        AttendanceVo vo1 = new AttendanceVo();
        AttendanceVo vo2 = new AttendanceVo();
        vo1.setDay(strDate1);
        vo2.setDay(strDate2);
        vo1.setWorkhours(6);
        vo1.setUserId(75);
        vo2.setWorkhours(6);
        vo2.setUserId(75);
        list.add(vo1);
        list.add(vo2);
        int t =ext.saveRecords(list);
        System.out.println("=========================="+t);
    }

    @Test
    public void test6(){
        List<AttendanceVo>list = new ArrayList<AttendanceVo>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate1 = "2015-09-23";
        String strDate2 = "2015-09-22";
        AttendanceVo vo1 = new AttendanceVo();
        vo1.setDay(strDate1);
        vo1.setWorkhours(6);
        vo1.setUserId(75);
        list.add(vo1);
        int t =ext.saveRecord(vo1);
        System.out.println("=========================="+t);
    }
}

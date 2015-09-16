package com.isoftstone.kaoqin.service.test;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo;
import com.isoftstone.kaoqin.service.AttendanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring_mybatis.xml" })
public class AttendanceServiceTest {
    @Autowired
    private AttendanceService attendanceService;

    @Test
    public void test1(){
        int cur =2 ;
        BasicAttendance<List<AttendanceVo>> basicAttendance = attendanceService.findAll(cur);
        List<AttendanceVo> list = basicAttendance.getData();
        for(AttendanceVo vo:list){
            System.out.println(vo);
        }

    }
}

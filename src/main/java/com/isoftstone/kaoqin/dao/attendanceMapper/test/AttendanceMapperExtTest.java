package com.isoftstone.kaoqin.dao.attendanceMapper.test;

import com.isoftstone.kaoqin.controller.vo.AttendanceVo;
import com.isoftstone.kaoqin.dao.attendanceMapper.AttendanceMapperExt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.print(ext.getClass().getName());
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("limit",0);
        map.put("size", 2);
        List<AttendanceVo>list =  ext.selectAll(map);
        for(AttendanceVo vo :list){
            System.out.println(vo);
        }
    }

}

package com.isoftstone.kaoqin.service.test;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.controller.vo.PasswordModify;
import com.isoftstone.kaoqin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring_mybatis.xml" })
public class UserServiceTest {
    @Autowired(required = true)
    private UserService userService;

    /**
     * 检测登入功能
     * */
    @Test
    public void test1(){
        BasicAttendance basicAttendance = userService.toLogin("admin","");
        System.out.println(basicAttendance);
    }

    /**更改密码测试*/
    @Test
    public void test2(){
        PasswordModify pm = new PasswordModify();
        pm.setIsoftNo("78611");
        pm.setNewPwd("12312");
        pm.setPostPwd("123456");
        BasicAttendance b = userService.modfifyPwd(pm);
        System.out.println(b);
    }
}

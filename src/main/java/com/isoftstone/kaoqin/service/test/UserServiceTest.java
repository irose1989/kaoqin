package com.isoftstone.kaoqin.service.test;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.controller.vo.PasswordModify;
import com.isoftstone.kaoqin.controller.vo.SearchConditions;
import com.isoftstone.kaoqin.service.PermissionService;
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
    @Autowired
    private PermissionService permissionService;
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

    @Test
    public void test3(){
        BasicAttendance basicAttendance = userService.findAllUser();
        System.out.print(basicAttendance);
    }

    /**测试权限修改*/
    @Test
    public void test4(){
        SearchConditions conditions = new SearchConditions();
        conditions.setRoleId(1);
        conditions.setIsoftNo("2");
        BasicAttendance basicAttendance = permissionService.changeRole(conditions);
        System.out.println(basicAttendance);
    }

    /**测试更改用户信息*/
    @Test
    public void test5(){
        User user = new User();
        user.setIsoftNo("3");
        user.setRealName("chen");
        BasicAttendance basicAttendance = userService.editUserInfo(user);
        System.out.println(basicAttendance);

    }

}

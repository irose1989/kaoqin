package com.isoftstone.kaoqin.dao.test;

import com.isoftstone.kaoqin.bean.User;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring_mybatis.xml" })
public class UserDaoTest {
    @Autowired
    private ApplicationContext atx;
    @Autowired
    private UserDao dao;
    /**
     * 根据用户名查找用户信息
     * */
    //@Test
    public void test1(){
        String username = "admin";
        User user = dao.findByName(username);
        BasicAttendance kq = new BasicAttendance();
        kq.setObject((Object)user);
        System.out.print(kq);
    }
    /**
     * 插入新的用户
     * */
    @Test
    public void test2(){
        User u = new User();
        u.setName("chao");
        u.setPassword("123");
        u.setDept_no(10);
        boolean flag = dao.registUser(u);
        System.out.println(flag);
    }

}
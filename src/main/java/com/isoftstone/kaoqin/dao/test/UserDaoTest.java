package com.isoftstone.kaoqin.dao.test;

import com.isoftstone.kaoqin.bean.User;
import com.isoftstone.kaoqin.common.BasicKq;
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
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class UserDaoTest {
    @Autowired
    private ApplicationContext atx;
    @Autowired
    private UserDao dao;
    @Test
    public void test1(){
        String username = "admin";
        User user = dao.findByName(username);
        BasicKq kq = new BasicKq();
        kq.setObject((Object)user);
        System.out.print(kq);
    }
}

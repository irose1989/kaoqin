package com.isoftstone.kaoqin.service.UserServiceTest;

import com.isoftstone.kaoqin.common.BasicKq;
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
    @Autowired
    private UserService userService;
    @Test
    public void test1(){
        BasicKq kq = userService.findByName("1");
        System.out.println(kq);
    }
}

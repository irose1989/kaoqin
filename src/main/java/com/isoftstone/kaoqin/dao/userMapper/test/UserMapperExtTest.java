package com.isoftstone.kaoqin.dao.userMapper.test;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.dao.userMapper.UserMapperExt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring_mybatis.xml" })
public class UserMapperExtTest {

    @Autowired
    private UserMapperExt ext;
    @Test
    public void test1(){

        List<User> list = new ArrayList<User>();
        for(int i = 0 ; i<3;i++){
            User user = new User();
            user.setIsoftNo("3"+i+"0");
            user.setRoleid(1);
            list.add(user);
        }
        for(User i:list){
            System.out.println(i.getIsoftNo());
        }
        int code = ext.batchOpenAccount(list);
            System.out.println(code);
    }

}

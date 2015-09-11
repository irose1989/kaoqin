package com.isoftstone.kaoqin.dao;

import com.isoftstone.kaoqin.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */

@Repository
public interface UserDao {
    /**用户登入 根据用户名查找用户信息*/
    User findByName(String name);
    /**用户注册*/
    boolean registUser(User user);
}

package com.isoftstone.kaoqin.dao;

import com.isoftstone.kaoqin.bean.User;
import com.isoftstone.kaoqin.common.BasicKq;
import org.springframework.stereotype.Repository;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */

@Repository
public interface UserDao {
    public User findByName(String name);
}

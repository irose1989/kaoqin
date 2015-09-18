package com.isoftstone.kaoqin.dao.userMapper;

import com.isoftstone.kaoqin.bean.user.User;

import java.util.List;

public interface UserMapperExt extends UserMapper{
    int batchOpenAccount(List<User> userList);
}
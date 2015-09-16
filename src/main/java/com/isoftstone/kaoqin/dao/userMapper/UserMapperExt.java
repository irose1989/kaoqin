package com.isoftstone.kaoqin.dao.userMapper;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.bean.user.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperExt extends UserMapper{
    int batchOpenAccount(List<User> userList);
}
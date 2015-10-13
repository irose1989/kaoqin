package com.isoftstone.kaoqin.dao.userMapper;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.controller.vo.UserVo;

import java.util.List;
import java.util.Map;

public interface UserMapperExt extends UserMapper{
    int batchOpenAccount(List<User> userList);
    List<UserVo> findUserByCondition(Map map);
}
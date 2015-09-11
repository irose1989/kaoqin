package com.isoftstone.kaoqin.service;

import com.isoftstone.kaoqin.common.BasicAttendance;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
public interface UserService {
    /**用户登入*/
    public BasicAttendance toLogin(String userName,String password);
}

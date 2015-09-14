package com.isoftstone.kaoqin.service;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.controller.vo.UserVo;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
public interface UserService {
    /**用户登入*/
    public BasicAttendance<User> toLogin(String userName,String password);
    /**账号开通*/
    public BasicAttendance openAccount(UserVo vo);
    /**编辑个人信息*/
    public  BasicAttendance editUserInfo(User user);
}

package com.isoftstone.kaoqin.service;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.controller.vo.PasswordModify;
import com.isoftstone.kaoqin.controller.vo.UserVo;
import com.isoftstone.kaoqin.controller.vo.UserVoList;


/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
public interface UserService {
    /**用户登入*/
    BasicAttendance toLogin(String userName,String password);
    /**账号开通*/
    BasicAttendance<User> openAccount(UserVo vo);
    /**批量开通账户*/
    BasicAttendance<User> batchOpenAccount(UserVoList userList);
    /**编辑个人信息*/
    BasicAttendance<User> editUserInfo(User user);
    /**密码更改*/
    BasicAttendance modfifyPwd(PasswordModify passwordModify);
    /**检查用户是否存在*/
    BasicAttendance checkUserExist(String userName);
    /**搜索用户信息*/
    BasicAttendance findByConditions(UserVo userVo);
    /**搜索所有用户*/
    BasicAttendance findAllUser();

}

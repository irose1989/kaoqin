package com.isoftstone.kaoqin.service.impl;

import com.isoftstone.kaoqin.bean.User;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.UserConstants;
import com.isoftstone.kaoqin.dao.UserDao;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;
    /**
     * 检查用户名 密码 正不正确
     * */
    public BasicAttendance toLogin(String userName,String password) {
        BasicAttendance basicAttendance = new BasicAttendance();
        /**用户名为空时；*/
        if(StringUtils.isEmpty(userName)){
            basicAttendance.setCode(UserConstants.userNotPut);
            basicAttendance.setMsg(UserConstants.userNotPutMsg);
            return  basicAttendance;
        }
        basicAttendance = checkUserExist(userName);
        User user = (User)basicAttendance.getData();
        /**如果用户名不为空，但匹配不到用户名*/
        if(StringUtils.isEmpty(user)){
            return basicAttendance;
        }
        /**如果用户名存在 就匹配密码；*/
        String pwd = user.getPassword();
        /**密码匹配正确；未输入密码*/
        if(StringUtils.isEmpty(password)){
            basicAttendance.setMsg(UserConstants.pwdNotPutMsg);
            basicAttendance.setCode(UserConstants.pwdNotPut);
            return basicAttendance;
        }
        /**密码匹配正确；*/
        if(com.alibaba.druid.util.StringUtils.equals(password,pwd)){
            basicAttendance.setMsg(UserConstants.loginSuccessMsg);
            basicAttendance.setCode(UserConstants.loginSuccess);
            return  basicAttendance;
        }
        /**密码错误；*/
        basicAttendance.setMsg(UserConstants.pwdErrorMsg);
        basicAttendance.setCode(UserConstants.pwdError);
        return basicAttendance;
    }

    /**
     * 检查用户存不存在
     * */
    public BasicAttendance checkUserExist(String userName){
        BasicAttendance<User> basicAttendance = new BasicAttendance<User>();
        /**没有匹配到用户名；*/
        User user = dao.findByName(userName);
        if(StringUtils.isEmpty(user)){
            basicAttendance.setCode(UserConstants.userNotExisted);
            basicAttendance.setMsg(UserConstants.userNotExistedMsg);
            return basicAttendance;
        }
        /**根据用户名返回该用户的信息；*/
        basicAttendance.setCode(UserConstants.userExisted);
        basicAttendance.setMsg(UserConstants.userExistedMsg);
        basicAttendance.setData(user);
        return basicAttendance;
    }

}

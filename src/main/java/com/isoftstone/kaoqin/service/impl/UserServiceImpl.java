package com.isoftstone.kaoqin.service.impl;

import com.isoftstone.kaoqin.bean.User;
import com.isoftstone.kaoqin.common.BasicKq;
import com.isoftstone.kaoqin.common.constants.UserConstants;
import com.isoftstone.kaoqin.dao.UserDao;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    public BasicKq findByName(String userName) {
        BasicKq kq = new BasicKq();
        if(userName ==null || userName ==""){
            kq.setCode(UserConstants.userNotPut);
            kq.setMsg(UserConstants.userNotPutMsg);
        }
        User user = dao.findByName(userName);
        if(user==null){
            kq.setCode(UserConstants.userNotExisted);
            kq.setMsg(UserConstants.userNotExistedMsg);
            return kq;
        }
        kq.setCode(UserConstants.userExisted);
        kq.setMsg(UserConstants.userExistedMsg);
        return kq;
    }
}

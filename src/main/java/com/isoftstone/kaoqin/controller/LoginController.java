package com.isoftstone.kaoqin.controller;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private UserService userService;


    @RequestMapping("/login.do")
    public BasicAttendance toLogin(String username,String password){

        return null;
    }

    @RequestMapping("/checkUserExist.do")
    @ResponseBody
    public BasicAttendance checkUserExist(String username,String password){
        BasicAttendance kq = userService.toLogin(username,password);
        return kq;
    }
}

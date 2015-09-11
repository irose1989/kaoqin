package com.isoftstone.kaoqin.controller;

import com.isoftstone.kaoqin.bean.TestForm;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/checkUserExist.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance checkUserExist(@RequestBody TestForm form){
        BasicAttendance kq = userService.toLogin(form.getUserName(),form.getPassword());
        return kq;
    }
}

package com.isoftstone.kaoqin.controller;

import com.isoftstone.kaoqin.common.BasicKq;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping("/checkUserExist.do")
    public String checkUserExist(String username){

        BasicKq kq = userService.findByName(username);
        if(kq.getCode()==0){
            return kq.getMsg();
        }
        return null;
    }
}

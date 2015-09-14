package com.isoftstone.kaoqin.controller;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.controller.vo.UserVo;
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


    //@RequestMapping("/login.do")
    public BasicAttendance toLogin(String username,String password){

        return null;
    }

    /**
     * 用户登入检查(默认员工号登入)
     * */
    @RequestMapping(value = "/toLogin.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance toLogin(@RequestBody UserVo userVo){
        BasicAttendance basicAttendance = userService.toLogin(userVo.getIsoftNo(),userVo.getPassword());
        return basicAttendance;
    }

    /**
     * 用户注册
     * */
}

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
 * Created by wb-chenchaobin on 2015/9/14.
 */
@RequestMapping("/admin")
@Controller
public class AccountController {
    @Autowired
    private UserService userService;

    @RequestMapping(value ="/openAccount.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance openAccount(@RequestBody UserVo vo){
        BasicAttendance basicAttendance= userService.openAccount(vo);
        return basicAttendance;
    }
}

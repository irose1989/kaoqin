package com.isoftstone.kaoqin.controller;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.common.BasicAttendance;
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
@Controller
@RequestMapping
public class UserInfoEditController {
    @Autowired
    private UserService userService;

    @RequestMapping(value ="/editInfo.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance editInfo(@RequestBody User user){
        BasicAttendance basicAttendance = userService.editUserInfo(user);
        return basicAttendance;
    }
}

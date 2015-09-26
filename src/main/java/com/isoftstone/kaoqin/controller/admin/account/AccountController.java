package com.isoftstone.kaoqin.controller.admin.account;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.controller.vo.*;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 管理员相关
 * Created by wb-chenchaobin on 2015/9/14.
 */
@RequestMapping("/account")
@Controller
public class AccountController {
    @Autowired
    private UserService userService;
    /**开通账号*/
    @RequestMapping(value = "/openAccount.do" ,method = RequestMethod.GET)
    public String openAccount(){
        return "createAccount";
    }
    /**
     * 开通一个账号
     * */
   /* @RequestMapping(value ="/openAccount.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance openAccount(@RequestBody UserVo vo){
        BasicAttendance basicAttendance= userService.openAccount(vo);
        return basicAttendance;
    }*/
    /**检查账号是否已经开通*/
    @ResponseBody
    @RequestMapping(value = "/checkUser",method = RequestMethod.GET)
    public BasicAttendance checkUser(String isoftNo,HttpServletResponse response){
        BasicAttendance basicAttendance = userService.checkUserExist(isoftNo);
        /*response.setHeader("Access-Control-Allow-Origin","*");*/
        return basicAttendance;
    }

    /**批量开通账号*/
    @RequestMapping(value = "/batchOpenAccount.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance batchOpenAccount(@RequestBody UserVoList userVoList){
        BasicAttendance basicAttendance = userService.batchOpenAccount(userVoList);
        return basicAttendance;
    }


}

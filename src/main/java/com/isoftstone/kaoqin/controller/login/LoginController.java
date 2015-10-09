package com.isoftstone.kaoqin.controller.login;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.UserConstants;
import com.isoftstone.kaoqin.controller.vo.PasswordModify;
import com.isoftstone.kaoqin.controller.vo.UserVo;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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
    @RequestMapping(value = "/toLogin.do",method = RequestMethod.GET)
    @ResponseBody
    public BasicAttendance toLogin(HttpServletRequest request,UserVo userVo) throws ServletException, IOException {
        HttpSession session = request.getSession();
        BasicAttendance basicAttendance = userService.toLogin(userVo.getIsoftNo(),userVo.getPassword());

        int code = basicAttendance.getCode();
        if(UserConstants.loginSuccess == code){
            Object userInfo = basicAttendance.getData();
            /**登入成功，储存到session*/
            session.setAttribute("userInfo",userInfo);
        }

        return basicAttendance;
    }


    /**
     * 用户密码更改
     * */
    @RequestMapping(value = "/checkPwd.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance checkPwd(@RequestBody PasswordModify passwordModify){
        BasicAttendance basicAttendance =  userService.modfifyPwd(passwordModify);
        return basicAttendance;
    }


    @RequestMapping(value = "/toPage.do")
    public String toPage(HttpServletRequest request){

        return "attendance";
    }

}

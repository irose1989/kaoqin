package com.isoftstone.kaoqin.controller.users;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.UserConstants;
import com.isoftstone.kaoqin.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wb-chenchaobin on 2015/9/14.
 */
@Controller
@RequestMapping("/userInfoEdit")
public class UserInfoEditController {
    @Autowired
    private UserService userService;


    @RequestMapping(value ="/editInfo.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance editInfo(@RequestBody User user){
        BasicAttendance basicAttendance = userService.editUserInfo(user);
        return basicAttendance;
    }

    /**跳转到编辑个人信息页面*/
    @RequestMapping(value = "/toEditInfo.do")
    public String openAccount(){
        return "userInfoEdit";
    }

    /**编辑个人信息*/
    @RequestMapping(value = "/editUserInfo.do",method = RequestMethod.POST)
    @ResponseBody
    public BasicAttendance editUserInfo(@RequestBody User user,HttpServletRequest request){
        BasicAttendance basicAttendance = userService.editUserInfo(user);
        /**编辑成功之后 重置session*/
        int code = basicAttendance.getCode();
        if(code == UserConstants.editUserInfoCode){
            HttpSession session = request.getSession();
            JSONObject infoUser = JSONObject.fromObject(user);
            session.setAttribute("infoUser",infoUser);
            session.setAttribute("userInfo",user);
        }
        return  basicAttendance;
    }

}

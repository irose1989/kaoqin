package com.isoftstone.kaoqin.controller.login;

import com.isoftstone.kaoqin.common.BasicAttendance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wb-chenchaobin on 2015/10/10.
 */
@Controller
@RequestMapping
public class LogoutController {

    @RequestMapping("/logout.do")
    @ResponseBody
    public BasicAttendance logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        BasicAttendance basicAttendance = new BasicAttendance();
        basicAttendance.setCode(0);
        return basicAttendance;
    }
}

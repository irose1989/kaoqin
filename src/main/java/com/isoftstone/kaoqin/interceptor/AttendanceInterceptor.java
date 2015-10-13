package com.isoftstone.kaoqin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by wb-chenchaobin on 2015/10/9.
 */
public class AttendanceInterceptor implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /**控制访问只能登入页面进来*/
        HttpSession session = httpServletRequest.getSession();
        Object userInfo = session.getAttribute("userInfo");
        /*if(userInfo == null){
            httpServletResponse.sendRedirect("/kaoqin/login.htm");
            return false;
        }*/
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

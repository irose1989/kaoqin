package com.isoftstone.kaoqin.controller.admin.permission;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.controller.vo.SearchConditions;
import com.isoftstone.kaoqin.controller.vo.UserVo;
import com.isoftstone.kaoqin.service.PermissionService;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 权限分配
 * Created by Administrator on 2015/9/26.
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    /**权限分配 加载页面*/
    @RequestMapping(value = "/getPermission.do",method = RequestMethod.GET)
    public String getPermission( ){
        return "permission";
    }



    /**搜索人员*/
    @RequestMapping(value = "/searchUser.do",method = RequestMethod.GET)
    @ResponseBody
    public BasicAttendance searchUser( UserVo userVo){
        BasicAttendance basicAttendance = userService.findByConditions(userVo);
        return  basicAttendance;
    }

    /**修改权限*/
    @RequestMapping(value = "/changeRole.do",method = RequestMethod.GET)
    @ResponseBody
    public BasicAttendance changeRole(SearchConditions conditions){
        BasicAttendance basicAttendance = permissionService.changeRole(conditions);
        return  basicAttendance;
    }


}

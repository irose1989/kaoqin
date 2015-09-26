package com.isoftstone.kaoqin.controller.admin.permission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权限分配
 * Created by Administrator on 2015/9/26.
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    /**权限分配*/
    @RequestMapping(value = "/getPermission.do")
    public String getPermission(){
        return "permission";
    }

}

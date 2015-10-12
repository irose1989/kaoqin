package com.isoftstone.kaoqin.service.impl;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.bean.user.UserExample;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.UserConstants;
import com.isoftstone.kaoqin.controller.vo.SearchConditions;
import com.isoftstone.kaoqin.dao.userMapper.UserMapperExt;
import com.isoftstone.kaoqin.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wb-chenchaobin on 2015/10/12.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private UserMapperExt userMapperExt;

    /**修改用户权限*/
    public BasicAttendance changeRole(SearchConditions conditions){
        BasicAttendance basicAttendance = new BasicAttendance();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIsoftNoEqualTo(conditions.getIsoftNo());
        User user = new User();
        user.setRoleid(conditions.getRoleId());
        int code = userMapperExt.updateByExampleSelective(user,example);
        if(code ==1){
            basicAttendance.setMsg(UserConstants.changePermissonSuccessMsg);
            basicAttendance.setCode(UserConstants.changePermissonSuccessCode);
        }else{
            basicAttendance.setMsg(UserConstants.changePermissonFailedMsg);
            basicAttendance.setCode(UserConstants.changePermissonFailedCode);
        }
        return basicAttendance;
    }


}

package com.isoftstone.kaoqin.service;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.controller.vo.SearchConditions;

/**
 * Created by wb-chenchaobin on 2015/10/12.
 */
public interface PermissionService {
    public BasicAttendance changeRole(SearchConditions conditions);
}

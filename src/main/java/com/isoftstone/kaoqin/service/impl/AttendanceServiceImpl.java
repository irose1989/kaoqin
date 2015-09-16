package com.isoftstone.kaoqin.service.impl;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.BasicConstants;
import com.isoftstone.kaoqin.common.utils.PageUtil;
import com.isoftstone.kaoqin.controller.vo.AttendanceVo;
import com.isoftstone.kaoqin.dao.attendanceMapper.AttendanceMapperExt;
import com.isoftstone.kaoqin.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private  AttendanceMapperExt admExt;
    /**分页查询考勤记录*/
    public BasicAttendance<List<AttendanceVo>> findAll(int currentPage) {
        int page = currentPage-1;
        int size = BasicConstants.PAGESIZE;
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("limit",page);
        map.put("size", size);
        List<AttendanceVo>voList = admExt.selectAll(map);
        int totalResults=getCounts();
        return PageUtil.getPage(voList,totalResults,page);
    }
    public int getCounts(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        /**limit设为-1，即查找所有*/
        map.put("limit",-1);
        map.put("size", BasicConstants.PAGESIZE);
        List<AttendanceVo>voList = admExt.selectAll(map);
        if(CollectionUtils.isEmpty(voList)){
            return 0;
        }
        else return  voList.size();
    }

}

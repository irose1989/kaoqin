package com.isoftstone.kaoqin.controller.attendence;

import com.isoftstone.kaoqin.controller.vo.AttendanceDateVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
@Controller
@RequestMapping("/attend")
public class AttendanceController {

    @RequestMapping("/getDate.do")
    public String getAttendanceDate(@RequestBody AttendanceDateVo dateVo){
        return null;
    }
}

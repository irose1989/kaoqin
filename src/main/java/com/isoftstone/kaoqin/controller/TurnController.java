package com.isoftstone.kaoqin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wb-chenchaobin on 2015/9/11.
 */

@Controller
@RequestMapping("/test")
public class TurnController {

    @RequestMapping("/toPage.do")
    public String turn(){
        System.out.print("进入conreoller===================");
        return "test";
    }
}

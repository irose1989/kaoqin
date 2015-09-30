package com.isoftstone.kaoqin.utils;

import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;


/**
 * Created by wb-chenchaobin on 2015/10/8.
 */
public class TimerTaskerUtil extends QuartzJobBean {
    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }

    public void getTest(){
        System.out.println("=====执行TimerTask定时成功=====");
    }


}

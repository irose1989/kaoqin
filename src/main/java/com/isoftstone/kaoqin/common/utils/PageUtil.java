package com.isoftstone.kaoqin.common.utils;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.BasicConstants;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class PageUtil {
    public static <T>BasicAttendance<T> getPage
            (T t,int totalResults, int page){
        BasicAttendance<T> basicAttendance = new BasicAttendance<T>();
        PageConf pageConf = new PageConf();
        int pre = 0;
        int next = 0;
        int currentPage = page + 1;
        int totalPage = totalResults/BasicConstants.PAGESIZE;
        if (totalResults % BasicConstants.PAGESIZE > 0) {
            totalPage++;
        }
        if (totalPage == 1 || totalPage == 0) {
            pre = 1;
            next = 1;
            currentPage = 1;
            totalPage = 1;
        }
        if (totalPage > 1 && currentPage == totalPage) {
            pre = currentPage - 1;
            next = currentPage;
        }
        if (totalPage > 1 && currentPage == 1) {
            pre = currentPage;
            next = currentPage + 1;
        }
        if (totalPage > 1 && currentPage > 1 && currentPage < totalPage) {
            pre = currentPage - 1;
            next = currentPage + 1;
        }
        pageConf.setCurrentPage(currentPage);
        pageConf.setTotalPage(totalPage);
        pageConf.setNext(next);
        pageConf.setPre(pre);
        basicAttendance.setData(t);
        basicAttendance.setPageConf(pageConf);
        return basicAttendance;
    }
}

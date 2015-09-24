package com.isoftstone.kaoqin.common.utils;

import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.BasicConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class PageUtil {
    public static <T>BasicAttendance<T> getPage
            (T t,int totalResults, PageConf pageConf ){
        BasicAttendance<T> basicAttendance = new BasicAttendance<T>();
        Integer pre = pageConf.getPre();
        Integer next = pageConf.getNext();
        Integer currentPage = pageConf.getCurrentPage();

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
    public static <T>List<T> getPageList(List<T> list,int limit,int size){
        List<T> newList = new ArrayList<T>();
            for(int i =0;i<list.size();i++){
                if(i>=limit && i<limit+size){
                    newList.add(list.get(i));
                }
            }
        return newList;
    }
    public static PageConf getNewPageConf(int totalResults,PageConf pageConf){
        Integer pre = pageConf.getPre();
        Integer next = pageConf.getNext();
        Integer currentPage = pageConf.getCurrentPage();
        int totalPage = totalResults/BasicConstants.PAGESIZE;//(取整)
        /**点击下一页 */
        if(pre == null && next !=null){

        }
        return null;
    }
}

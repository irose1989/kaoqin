package com.isoftstone.kaoqin.controller.vo;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class PageVo {
    private Integer currentPage;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "currentPage=" + currentPage +
                '}';
    }
}

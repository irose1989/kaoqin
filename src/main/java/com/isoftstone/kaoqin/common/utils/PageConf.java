package com.isoftstone.kaoqin.common.utils;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class PageConf {
    /**上一页*/
    private  Integer pre ;
    /**下一页*/
    private  Integer next ;
    /**当前页*/
    private  Integer currentPage ;
    /**总页数*/
    private Integer totalPage ;

    public Integer getPre() {
        return pre;
    }

    public void setPre(Integer pre) {
        this.pre = pre;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageConf{" +
                "pre=" + pre +
                ", next=" + next +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                '}';
    }
}

package com.isoftstone.kaoqin.common.utils;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class PageConf {
    /**上一页*/
    private  int pre = 0;
    /**下一页*/
    private  int next = 0;
    /**当前页*/
    private  int currentPage =0;
    /**总页数*/
    private int totalPage =0;

    public int getPre() {
        return pre;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
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

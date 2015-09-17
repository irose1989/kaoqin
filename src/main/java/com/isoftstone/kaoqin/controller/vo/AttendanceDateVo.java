package com.isoftstone.kaoqin.controller.vo;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class AttendanceDateVo {
    private int month;
    private int year;
    private List<String> upDateList;
    private List<String> downDateList;
    private int upOrDown;

    public int getUpOrDown() {
        return upOrDown;
    }

    public void setUpOrDown(int upOrDown) {
        this.upOrDown = upOrDown;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getUpDateList() {
        return upDateList;
    }

    public void setUpDateList(List<String> upDateList) {
        this.upDateList = upDateList;
    }

    public List<String> getDownDateList() {
        return downDateList;
    }

    public void setDownDateList(List<String> downDateList) {
        this.downDateList = downDateList;
    }

    @Override
    public String toString() {
        return "AttendanceDateVo{" +
                "month=" + month +
                ", year=" + year +
                ", upDateList=" + upDateList +
                ", downDateList=" + downDateList +
                ", upOrDown=" + upOrDown +
                '}';
    }
}

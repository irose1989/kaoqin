package com.isoftstone.kaoqin.controller.vo;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class AttendanceDateVo {
    private int month;
    private int year;
    private List<String> dateList;
    private Integer upOrDown;

    /**上下旬时间区间的String 类型*/
    private String from;
    private String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getUpOrDown() {
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


    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    @Override
    public String toString() {
        return "AttendanceDateVo{" +
                "month=" + month +
                ", year=" + year +
                ", dateList=" + dateList +
                ", upOrDown=" + upOrDown +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}

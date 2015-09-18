package com.isoftstone.kaoqin.controller.vo;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class AttendanceDateVo {
    private Integer month;
    private Integer year;
    private List<String> dateList;
    private Integer upOrDown;

    /**上下旬时间区间的String 类型*/
    private String from;
    private String to;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    public Integer getUpOrDown() {
        return upOrDown;
    }

    public void setUpOrDown(Integer upOrDown) {
        this.upOrDown = upOrDown;
    }

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

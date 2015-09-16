package com.isoftstone.kaoqin.controller.vo;

/**
 * Created by wb-chenchaobin on 2015/9/16.
 */
public class AttendanceDate {
    private int month;
    private int year;

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

    @Override
    public String toString() {
        return "AttendanceDate{" +
                "month=" + month +
                ", year=" + year +
                '}';
    }
}

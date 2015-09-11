package com.isoftstone.kaoqin.bean;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
public class Dept {
    private int dept_no;
    private String dept_name;

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dept_no=" + dept_no +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
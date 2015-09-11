package com.isoftstone.kaoqin.common;

import com.isoftstone.kaoqin.bean.User;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */

public class BasicAttendance<T> {

    private String msg;
    private int code;//0:不存在；1；存在用户
    private T data;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

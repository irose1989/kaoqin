package com.isoftstone.kaoqin.common;

import com.isoftstone.kaoqin.bean.User;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
public class BasicKq {

    private String msg;
    private int code;//0:不存在；1；存在用户
    private Object object;

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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void setObject(User user) {
        this.object = user;
    }

    @Override
    public String toString() {
        return "BasicKq{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", object=" + object +
                '}';
    }
}

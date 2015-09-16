package com.isoftstone.kaoqin.common;

import com.alibaba.druid.util.StringUtils;
import com.isoftstone.kaoqin.common.constants.UserConstants;
import com.isoftstone.kaoqin.common.utils.PageConf;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */

public class BasicAttendance<T> {

    private String msg;
    private int code;//0:不存在；1；存在用户
    private boolean flag;
    private T data;
    private PageConf pageConf;

    public PageConf getPageConf() {
        return pageConf;
    }

    public void setPageConf(PageConf pageConf) {
        this.pageConf = pageConf;
    }

/*    public boolean isFlag() {
        return flag;
    }*/

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

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

    public void clear(){
        this.msg="";
        this.code= 0;
        this.flag= false;
        this.data = null;
    }

    /**字符串为空时*/
    public boolean doEmpty(String pro){
        if (StringUtils.isEmpty(pro)){
            setMsg(UserConstants.notPutMsg);
            setCode(UserConstants.notPutCode);
            return true ;
        }
        return false;
    }
    /**集合为空时*/
    public boolean doEmpty(Collection<T> collection ){
        if (CollectionUtils.isEmpty(collection)){
            setMsg(UserConstants.notPutMsg);
            setCode(UserConstants.notPutCode);
            return true;
        }
        return false;
    }

    /**对象为null时*/
    public boolean doEmpity(Object o){
        if(null == o){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BasicAttendance{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", flag=" + flag +
                ", data=" + data +
                ", pageConf=" + pageConf +
                '}';
    }
}

package com.isoftstone.kaoqin.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wb-chenchaobin on 2015/9/15.
 */
public class Validate {
    /**手机号码验证*/
    public static boolean isMobile(String tel) {
        if (tel == null || "".equals(tel)) {
            return false;
        }
        Pattern p = Pattern.compile("^[1][0-9]{10}$");
        boolean b = false;
        Matcher m = p.matcher(tel);
        b = m.matches();
        return b;
    }
    /**
     * 密码验证
     * 英文字母和数字组成且必须已英文字母开头，不少于6位最大长度为20
     * */
    public static boolean checkPwd(String pwd){
        if (pwd == null || "".equals(pwd)) {
            return false;
        }
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{5,19}");
        boolean b = false;
        Matcher m = p.matcher(pwd);
        b = m.matches();
        return b;
    }
}

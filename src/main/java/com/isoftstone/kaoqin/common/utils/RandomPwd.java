package com.isoftstone.kaoqin.common.utils;

import java.util.Random;

/**
 * Created by wb-chenchaobin on 2015/9/14.
 */
public class RandomPwd {

    public static String getRandomPwd(int len){
        StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyz");
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int range = buffer.length();
        for (int i = 0; i < len; i ++) {
            sb.append(buffer.charAt(r.nextInt(range)));
        }
        return sb.toString();
    }
}

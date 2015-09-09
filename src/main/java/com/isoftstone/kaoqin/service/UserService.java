package com.isoftstone.kaoqin.service;

import com.isoftstone.kaoqin.common.BasicKq;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
public interface UserService {
    public BasicKq findByName(String userName);
}

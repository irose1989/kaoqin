package com.isoftstone.kaoqin.controller.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserVoList {
    private List<UserVo> userVoList;

    public List<UserVo> getUserVoList() {
        return userVoList;
    }

    public void setUserVoList(List<UserVo> userVoList) {
        this.userVoList = userVoList;
    }

    @Override
    public String toString() {
        return "UserVoList{" +
                "userVoList=" + userVoList +
                '}';
    }
}

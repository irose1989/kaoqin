package com.isoftstone.kaoqin.service.impl;

import com.isoftstone.kaoqin.bean.user.User;
import com.isoftstone.kaoqin.bean.user.UserExample;
import com.isoftstone.kaoqin.common.BasicAttendance;
import com.isoftstone.kaoqin.common.constants.RoleConstants;
import com.isoftstone.kaoqin.common.constants.UserConstants;
import com.isoftstone.kaoqin.common.utils.PageConf;
import com.isoftstone.kaoqin.common.utils.RandomPwd;
import com.isoftstone.kaoqin.common.utils.Validate;
import com.isoftstone.kaoqin.controller.vo.PasswordModify;
import com.isoftstone.kaoqin.controller.vo.UserVo;
import com.isoftstone.kaoqin.controller.vo.UserVoList;
import com.isoftstone.kaoqin.dao.userMapper.UserMapperExt;
import com.isoftstone.kaoqin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-chenchaobin on 2015/9/8.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = true)
    private UserMapperExt userMapper;

    /**
     * 检查用户名 密码 正不正确
     * */
    public BasicAttendance toLogin(String userName,String password) {
        BasicAttendance basicAttendance = new BasicAttendance();
        /**用户名为空时；*/
        if(StringUtils.isEmpty(userName)){
            basicAttendance.setCode(UserConstants.userNotPut);
            basicAttendance.setMsg(UserConstants.userNotPutMsg);
            return  basicAttendance;
        }
        basicAttendance = checkUserExist(userName);
        User user = (User)basicAttendance.getData();
        /**如果用户名不为空，但匹配不到用户名*/
        if(StringUtils.isEmpty(user)){
            return basicAttendance;
        }
        /**如果用户名存在 就匹配密码；*/
        String pwd = user.getPassword();
        /**密码匹配正确；未输入密码*/
        if(StringUtils.isEmpty(password)){
            basicAttendance.setMsg(UserConstants.pwdNotPutMsg);
            basicAttendance.setCode(UserConstants.pwdNotPut);
            return basicAttendance;
        }
        /**密码匹配正确；*/
        if(com.alibaba.druid.util.StringUtils.equals(password,pwd)){
            basicAttendance.setMsg(UserConstants.loginSuccessMsg);
            basicAttendance.setCode(UserConstants.loginSuccess);
            return  basicAttendance;
        }
        /**密码错误；*/
        basicAttendance.setMsg(UserConstants.pwdErrorMsg);
        basicAttendance.setCode(UserConstants.pwdError);
        return basicAttendance;
    }

    /**检查用户存不存在(员工工号)
     * false ：不存在该员工账号
     * true : 存在该员工账号；
     * */
    public BasicAttendance checkUserExist(String userName){
        BasicAttendance basicAttendance = new BasicAttendance<User>();
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsoftNoEqualTo(userName);
        /**没有匹配到用户名；*/
        List<User> userList = userMapper.selectByExample(userExample);
        if(CollectionUtils.isEmpty(userList)){
            basicAttendance.setCode(UserConstants.userNotExisted);
            basicAttendance.setMsg(UserConstants.userNotExistedMsg);
            basicAttendance.setFlag(false);
            return basicAttendance;
        }
        /**根据用户名返回该用户的信息；*/
        basicAttendance.setCode(UserConstants.userExisted);
        basicAttendance.setMsg(UserConstants.userExistedMsg);
        basicAttendance.setData(userList.get(0));
        basicAttendance.setFlag(true);
        return basicAttendance;
    }

    /**开通账户*/
    public BasicAttendance openAccount(UserVo vo) {
        BasicAttendance basicAttendance = new BasicAttendance();
        String isoftNo = vo.getIsoftNo();
        /**如果开通账户 工号为空*/
        if(StringUtils.isEmpty(isoftNo)){
            basicAttendance.setCode(UserConstants.accountNotPutCode);
            basicAttendance.setMsg(UserConstants.accountNotPutMsg);
        }
        /**密码未输入*/
       /* String password = vo.getPassword();
        if(StringUtils.isEmpty(password)){
            basicAttendance.setCode(UserConstants.pwdNotPut);
            basicAttendance.setMsg(UserConstants.pwdNotPutMsg);
        }*/
        /**用户名不为空*/
        basicAttendance = checkUserExist(isoftNo);
        User user = (User)basicAttendance.getData();
        /**返回用户不为空 说明已经被注册*/
        if(!StringUtils.isEmpty(user)){
            basicAttendance.setCode(UserConstants.accountExistedCode);
            basicAttendance.setMsg(UserConstants.accountExistedMsg);
            basicAttendance.setData(null);
            return basicAttendance;
        }
        /**没被注册*/
        user = new User();
        /**获取6位随机密码*/
        String password = RandomPwd.getRandomPwd(UserConstants.pwd_digit);
        /**默认用户权限：1，普通用户*/
        user.setRoleid(RoleConstants.GENERAL_ROLE);
        user.setIsoftNo(isoftNo);
        user.setPassword(password);
        int code =userMapper.insert(user);
        if(code>0){
            basicAttendance.setMsg(UserConstants.accountSuccessMsg);
            basicAttendance.setCode(UserConstants.accountSuscessCode);
            return basicAttendance;
        }
        basicAttendance.setMsg(UserConstants.accountFailedMsg);
        basicAttendance.setCode(UserConstants.accountFailedCode);
        return basicAttendance;
    }

    /**编辑用户信息 */
    public BasicAttendance editUserInfo(User user) {
        BasicAttendance basicAttendance = new BasicAttendance();
        if(StringUtils.isEmpty(user)){
            basicAttendance.setMsg("用户异常");
        }
        /**编辑个人信息*/
        String isoftNo = user.getIsoftNo();
        /**如果没有账号,编辑失败*/
        if(StringUtils.isEmpty(isoftNo)){
            basicAttendance.setCode(UserConstants.editUserInfoErrorCode);
            basicAttendance.setMsg(UserConstants.editUserInfoErrorMsg);
            return basicAttendance;
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIsoftNoEqualTo(isoftNo);
        int code = userMapper.updateByExampleSelective(user,userExample);
        /**编辑成功*/
        if(code>0){
            basicAttendance.setCode(UserConstants.editUserInfoCode);
            basicAttendance.setMsg(UserConstants.editUserInfoMsg);
            return basicAttendance ;
        }
        /**编辑失败*/
        basicAttendance.setCode(UserConstants.editUserInfoErrorCode);
        basicAttendance.setMsg(UserConstants.editUserInfoErrorMsg);
        return basicAttendance;
    }

    /**批量开通账户*/
    public BasicAttendance<User> batchOpenAccount(UserVoList userVoList) {
        BasicAttendance<User> basicAttendance = new BasicAttendance<User>();
        List<UserVo> voList = userVoList.getUserVoList();
        /**集合为空时*/
        if(CollectionUtils.isEmpty(voList)){
            basicAttendance.setCode(UserConstants.userNotPut);
            basicAttendance.setMsg(UserConstants.userNotPutMsg);
            return basicAttendance;
        }
        /**如果批量中没有空 也没有已经注册的 添加到User里面*/
        List<User>userList = new ArrayList<User>();
        /**检查集合中有没为空的 或者该账号是否已经开通*/
        for(UserVo vo:voList){
            String isoftNo = vo.getIsoftNo();
            /**当集合中有空的 数据 直接返回*/
            if(StringUtils.isEmpty(isoftNo)){
               /* basicAttendance.setCode(UserConstants.userNotPut);
                basicAttendance.setMsg(UserConstants.userNotPutMsg);*/
                /*return basicAttendance;*/
                continue;
            }
            /**当集合中的账号有已经注册的*/
            basicAttendance = checkUserExist(isoftNo);
            if(basicAttendance.getFlag()){
                /*basicAttendance.setCode(UserConstants.userExisted);
                basicAttendance.setMsg(UserConstants.userExistedMsg);
                return basicAttendance ;*/
                continue;
            }

            User user = new User();
            String password = RandomPwd.getRandomPwd(UserConstants.pwd_digit);
            user.setRoleid(RoleConstants.GENERAL_ROLE);
            user.setIsoftNo(isoftNo);
            user.setPassword(password);
            userList.add(user);
        }
        if(CollectionUtils.isEmpty(userList)){
            basicAttendance.clear();
            basicAttendance.setMsg("已存在账户");
            return basicAttendance;
        }
        int code = userMapper.batchOpenAccount(userList);

        basicAttendance.setCode(code);
        basicAttendance.setMsg("");
        basicAttendance.setData(null);
        return basicAttendance;
    }

    /**更改密码*/
    public BasicAttendance modfifyPwd(PasswordModify passwordModify) {
        BasicAttendance basicAttendance = new BasicAttendance();
        String postPwd = passwordModify.getPostPwd();
        String newPwd = passwordModify.getNewPwd();
        /**新旧密码有一个输入为空 就返回*/
        if(basicAttendance.doEmpty(postPwd) ||basicAttendance.doEmpty(newPwd)){
            return basicAttendance;
        }
        /**新密码是否符合规则*/
        if(!Validate.checkPwd(newPwd)){
            basicAttendance.setCode(UserConstants.illegalPwdCode);
            basicAttendance.setMsg(UserConstants.illegalPwdMsg);
            return basicAttendance;
        }
        /**旧密码是否正确*/
        String isoftNo = passwordModify.getIsoftNo();
        if(basicAttendance.doEmpty(isoftNo)){
            return  basicAttendance ;
        }
        basicAttendance = checkUserExist(isoftNo);
        User user = (User)basicAttendance.getData();
        if(basicAttendance.doEmpity(user)){
            return  basicAttendance ;
        }
        String oldPwd = user.getPassword();
        basicAttendance.clear();
        /**旧密码相匹配*/
        if(oldPwd.equals(postPwd)){
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIsoftNoEqualTo(isoftNo);
            user = new User();
            user.setPassword(newPwd);
            int code = userMapper.updateByExampleSelective(user,userExample);
            if (code>0){
                basicAttendance.setMsg(UserConstants.changePwdSuccessMsg);
                basicAttendance.setCode(UserConstants.changePwdSuccessCode);
                return basicAttendance;
            }else{
                basicAttendance.setMsg(UserConstants.changePwdFailedMsg);
                basicAttendance.setCode(UserConstants.changePwdFailedCode);
                return basicAttendance;
            }
        }
        /**旧密码不匹配*/
        basicAttendance.setMsg(UserConstants.oldPwdUnmatchMsg);
        basicAttendance.setCode(UserConstants.oldPwdUnmatchCode);
        return basicAttendance;
    }
}

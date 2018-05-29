/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.service.impl;

import com.hallom.constant.MessageConstant;
import com.hallom.constant.RSAConstant;
import com.hallom.dao.UserDao;
import com.hallom.entity.User;
import com.hallom.rong.RongCloud;
import com.hallom.rong.models.response.TokenResult;
import com.hallom.rong.models.user.UserModel;
import com.hallom.service.UserService;
import com.hallom.utils.AppRedisTemplate;
import com.hallom.utils.RSAUtil;
import com.hallom.utils.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;

/**
 *
 * @author wb-cb368615
 * @version $Id: UserServiceImpl.java, v 0.1 2018年04月18日 16:53 wb-cb368615 Exp $
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private AppRedisTemplate redisTemplate;

    @Override
    public void register(User user) throws BindException {
        checkRegisterInfo(user.getUsername(),user.getMobilephone());
        userDao.insert(user);
    }

    @Override
    public User login(String loginName, String password) throws Exception {
        User user=userDao.selectUserByUsernamAndPassword(loginName,password);
        if (null!=user) {
            com.hallom.rong.methods.user.User ryUser=new com.hallom.rong.methods.user.User(MessageConstant.APPKEY,MessageConstant.APPSECRET);
            RongCloud rongCloud=new RongCloud(MessageConstant.APPKEY,MessageConstant.APPSECRET);
            ryUser.setRongCloud(rongCloud);
            TokenResult tokenResult=ryUser.register(new UserModel(String.valueOf(user.getUid()),user.getUsername(),""));
            String token=tokenResult.getToken();
            user.setToken(token);
            if (StringUtils.isEmpty(user.getPortraitUrl())){
                user.setPortraitUrl("http://47.97.127.188:8080/1.png");
            }
            redisTemplate.set(token,user);
        }
        return user;
    }

    private void checkRegisterInfo(String username,String mobilephone) throws BindException {
        if (null!=userDao.selectUserByUsernameOrMobilephone(username,mobilephone)){
            throw new BindException("用户名或手机号码已注册","用户名或手机号码已注册");
        }
    }
}
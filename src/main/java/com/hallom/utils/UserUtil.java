/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.utils;

import com.hallom.constant.RSAConstant;
import com.hallom.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author wb-cb368615
 * @version $Id: UserUtil.java, v 0.1 2018年04月19日 11:07 wb-cb368615 Exp $
 */
@Component
public class UserUtil {
    @Autowired
    private  AppRedisTemplate redisTemplate;
    public   User getUser(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token=request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            return new User();
        }
        Object object= redisTemplate.get(token);
        if (null==object){
            return new User();
        }

        return (User)object;
    }
}
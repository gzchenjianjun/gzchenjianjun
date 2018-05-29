/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.utils;

import com.alibaba.fastjson.JSON;
import com.hallom.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;



@Component
public class AppRedisTemplate {
    @Autowired
    private  StringRedisTemplate redisTemplate;
    public <T> T execute(String key, Callback<T> callback){

        if (StringUtils.isEmpty(redisTemplate.opsForValue().get(key))){
            synchronized (this){
                if (StringUtils.isEmpty(redisTemplate.opsForValue().get(key))){
                     T t =callback.callBack();
                    redisTemplate.opsForValue().set(key, JSON.toJSONString(t));
                }
            }
        }
        return (T)JSON.parseArray(redisTemplate.opsForValue().get(key));

    }

    public void set (String key,Object obj){
        redisTemplate.opsForValue().set(key,JSON.toJSONString(obj));
    }

    public Object get(String key){
        return JSON.parseObject(redisTemplate.opsForValue().get(key), User.class);
    }

}
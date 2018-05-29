/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.service.impl;

import com.hallom.dao.TestDao;
import com.hallom.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author wb-cb368615
 * @version $Id: TestServiceImpl.java, v 0.1 2018年04月17日 15:29 wb-cb368615 Exp $
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public String get() {
        String s=redisTemplate.opsForValue().get("name");
        return s;

        //return testDao.get();
    }
}
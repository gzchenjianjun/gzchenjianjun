/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.service.impl;

import com.hallom.dao.SchoolDao;
import com.hallom.entity.School;
import com.hallom.enum_.RedisKey;
import com.hallom.service.SchoolService;
import com.hallom.utils.AppRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author wb-cb368615
 * @version $Id: SchoolServiceImpl.java, v 0.1 2018年04月18日 15:31 wb-cb368615 Exp $
 */
@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private AppRedisTemplate redisTemplate;
    @Autowired
    private SchoolDao        schoolDao;
    @Override
    public List<School> get() {
        return redisTemplate.execute(RedisKey.SCHOOLLIST.name(),()->schoolDao.get());
    }
}

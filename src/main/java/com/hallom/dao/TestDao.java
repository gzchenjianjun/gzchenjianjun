/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author wb-cb368615
 * @version $Id: TestDao.java, v 0.1 2018年04月17日 15:30 wb-cb368615 Exp $
 */
@Mapper
public interface TestDao {
    String get();
}
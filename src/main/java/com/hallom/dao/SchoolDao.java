/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.dao;

import com.hallom.entity.School;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author wb-cb368615
 * @version $Id: SchoolDao.java, v 0.1 2018年04月18日 16:17 wb-cb368615 Exp $
 */
@Mapper
public interface SchoolDao {
    List<School> get();
}
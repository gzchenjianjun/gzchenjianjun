/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.dao;

import com.hallom.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author wb-cb368615
 * @version $Id: UserDao.java, v 0.1 2018年04月18日 16:56 wb-cb368615 Exp $
 */
@Mapper
public interface UserDao {
    void insert(User user);
    User selectUserByUsernameOrMobilephone(@Param("username") String username,@Param("mobilephone") String mobilephone );
    User selectUserByUsernamAndPassword(@Param("loginName") String loginName,@Param("password") String password);
}
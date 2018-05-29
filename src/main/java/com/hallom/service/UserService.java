/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.service;

import com.hallom.entity.User;
import org.springframework.validation.BindException;

/**
 * @author wb-cb368615
 * @version $Id: UserService.java, v 0.1 2018年04月18日 16:51 wb-cb368615 Exp $
 */
public interface UserService {
    void register(User user) throws BindException;
    User login(String loginName,String password) throws Exception;
}
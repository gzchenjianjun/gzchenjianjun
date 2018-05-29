/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.service;

import org.springframework.validation.BindException;

/**
 *
 * @author wb-cb368615
 * @version $Id: CaptchaService.java, v 0.1 2018年04月18日 10:16 wb-cb368615 Exp $
 */
public interface CaptchaService {
    void get(String mobilephone) throws BindException;
    void check(String mobilephone,String captcha) throws BindException;
}
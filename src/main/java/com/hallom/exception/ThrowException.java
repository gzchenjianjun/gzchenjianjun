/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.exception;

import org.springframework.aop.ThrowsAdvice;

/**
 *
 * @author wb-cb368615
 * @version $Id: ThrowException.java, v 0.1 2018年04月19日 15:11 wb-cb368615 Exp $
 */
public class ThrowException implements ThrowsAdvice {
    public  void  afterThrowing(Exception e)  throws  Throwable{
        System.out.println("出异常了..."+e);
    }
}
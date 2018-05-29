/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.utils;

import java.util.UUID;

/**
 *
 * @author wb-cb368615
 * @version $Id: TokenUtil.java, v 0.1 2018年04月19日 10:23 wb-cb368615 Exp $
 */
public class TokenUtil {
    public static String create(){
        return UUID.randomUUID().toString();
    }
}
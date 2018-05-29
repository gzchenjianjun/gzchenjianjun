/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.enum_;


/**
 *
 * @author wb-cb368615
 * @version $Id: RedisKey.java, v 0.1 2018年04月18日 14:50 wb-cb368615 Exp $
 */
public enum RedisKey {
    /**
     * 验证码
     */
    CAPTCHA("CAPTCHA","验证码"),SCHOOLLIST("SCHOOLLIST","学校列表");

    String name;
    String desc;
    RedisKey(){}

    RedisKey(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {       return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>desc</tt>.
     *
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter method for property <tt>desc</tt>.
     *
     * @param desc value to be assigned to property desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
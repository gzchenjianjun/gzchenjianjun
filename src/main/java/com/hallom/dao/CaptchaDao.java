
package com.hallom.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author wb-cb368615
 * @version $Id: CaptchaDao.java, v 0.1 2018年03月20日 14:45 wb-cb368615 Exp $
 */
@Mapper
public interface CaptchaDao {
    void delete(String mobilephone);
    void insert(@Param("mobilephone") String mobilephone, @Param("captcha") String captcha);
    String get(String mobilephone);
}
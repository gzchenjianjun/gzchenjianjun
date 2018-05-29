/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 *
 * @author wb-cb368615
 * @version $Id: User.java, v 0.1 2018年04月18日 16:54 wb-cb368615 Exp $
 */
@Data
public class User {
    @NotEmpty(message = "用户名不能为空")
    private String  username;
    @NotEmpty(message = "密码不能为空")
    private String  password;
    @NotEmpty(message = "手机号码不能为空")
    @Pattern(regexp = "^1[3|4|5|7|8][0-9]\\d{4,8}$", message = "请输入正确的手机号码")
    private String  mobilephone;
    @Pattern(regexp = "^0|1", message = "请输入正确的性别")
    private String sex;
    @Min(value = 1,message = "请输入正确的学校")
    private Long    schoolId;
    @Past(message = "请输入正确的生日")
    private Date    birthday;
    @Past(message = "请输入正确的入学日期")
    private Date    admissionTime;
    private String portraitUrl;
    private String token;
    private Long uid;
}
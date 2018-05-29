/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.controller;

import com.hallom.entity.Result;
import com.hallom.entity.User;
import com.hallom.service.UserService;
import com.hallom.utils.UserUtil;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

/**
 * @author wb-cb368615
 * @version $Id: UserController.java, v 0.1 2018年04月18日 16:38 wb-cb368615 Exp $
 */
@RestController
@RequestMapping("/app/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserUtil userUtil;
    @RequestMapping("/register")
    public Result register(@RequestBody @Valid User param) throws BindException {
        userService.register(param);
        return Result.success();
    }

    @RequestMapping("/login")
    public Result<User> login(@RequestBody @Valid LoginParam param) throws Exception {
        return Result.success(userService.login(param.getLoginName(),param.getPassword()));
    }

}
@Data
class LoginParam{
    @NotEmpty(message = "登录名不能为空")
    private String loginName;
    @NotEmpty(message = "密码不能为空")
    private String password;
}


/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.controller;

import com.hallom.entity.Result;
import com.hallom.service.CaptchaService;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;


@RestController
@RequestMapping("/app/captcha")
public class CaptchaController {
    @Autowired
    private CaptchaService  captchaService;

    @RequestMapping("/get")
    public Result get(@Valid @RequestBody CaptchaParam param) throws BindException {
        captchaService.get(param.getMobilephone());
        return Result.success();
    }

    @RequestMapping("/check")
    public Result check(@Valid @RequestBody CaptchaParam param) throws BindException {
        captchaService.check(param.getMobilephone(),param.getCaptcha());
        return Result.success();
    }


}

@Data
class CaptchaParam{
    @NotEmpty(message = "手机号码不能为空")
    @Pattern(regexp="^1[3|4|5|7|8][0-9]\\d{4,8}$",message = "请输入正确的手机号码")
    private String mobilephone;
    private String captcha;
}

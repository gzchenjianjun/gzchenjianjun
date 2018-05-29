/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.controller;

import com.hallom.entity.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;

/**
 *
 * @author wb-cb368615
 * @version $Id: GlobalExceptionHandler.java, v 0.1 2018年04月17日 16:37 wb-cb368615 Exp $
 */
@RestControllerAdvice
public class GlobalExceptionHandler implements Serializable{
    private static final long serialVersionUID = 103186762185178610L;

    @ExceptionHandler(value={BindException.class})
    public Object MethodArgumentNotValidHandler(BindException exception)
    {
        StringBuffer sb=new StringBuffer();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            sb.append(error.getDefaultMessage());
        }
        if (StringUtils.isEmpty(sb.toString())){
            sb.append(exception.getBindingResult().getObjectName());
        }
        return Result.fail(sb.toString());
    }
    @ExceptionHandler(value={MethodArgumentNotValidException.class})
    public Object a(MethodArgumentNotValidException exception) {
        StringBuffer sb=new StringBuffer();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            sb.append(error.getDefaultMessage());
        }
        if (StringUtils.isEmpty(sb.toString())){
            sb.append(exception.getBindingResult().getObjectName());
        }
        return Result.fail(sb.toString());
    }

}
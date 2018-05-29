/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author wb-cb368615
 * @version $Id: Result.java, v 0.1 2018年04月17日 15:37 wb-cb368615 Exp $
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Boolean success;
    private String message;
    private T result;
    public static<T> Result<T> success(T result){
        return Result.<T>builder().success(true).result(result).build();
    }
    public static Result fail(String message){
        return Result.builder().success(false).message(message).build();
    }

    public Result(Boolean success, T t) {
        this.success = success;
        this.result = t;
    }
    public static<T> Result<T> success(){
        return Result.<T>builder().success(true).build();
    }
}
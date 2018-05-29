/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author wb-cb368615
 * @version $Id: PageResult.java, v 0.1 2018年04月17日 16:05 wb-cb368615 Exp $
 */
@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T>{
    private Long total;
    private Long pageSize=20L;
    private Long currentPage=1L;
    private List<T> pageList;
    public static<T> PageResult<T> success(List<T> result,Long total,Long pageSize,Long currentPage){
        PageResult<T> pageResult=new PageResult<>();
        pageResult.setCurrentPage(currentPage);
        pageResult.setPageList(result);
        pageResult.setTotal(total);
        pageResult.setPageSize(pageSize);
        return pageResult;
        //return PageResult.<T>builder().success(true).pageList(result).currentPage(currentPage).total(total).pageSize(pageSize).build();
    }
    //public static<T> PageResult<T> fail(String message){
    //    return PageResult.<T>builder().success(false).message(message).build();
    //}

}
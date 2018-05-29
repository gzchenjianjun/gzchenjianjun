/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.controller;

import com.hallom.entity.Result;
import com.hallom.entity.School;
import com.hallom.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author wb-cb368615
 * @version $Id: SchoolController.java, v 0.1 2018年04月18日 15:24 wb-cb368615 Exp $
 */
@RestController
@RequestMapping("/app/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @RequestMapping("/get")
    public Result<List<School>> get(){
        return Result.success(schoolService.get());
    }
}
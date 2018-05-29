/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.hallom.controller;

/**
 *
 * @author wb-cb368615
 * @version $Id: ImageController.java, v 0.1 2018年04月19日 11:34 wb-cb368615 Exp $
 */

import com.hallom.entity.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/app/image")
@RestController
public class ImageController {
    @Value("${web.upload-path}")
    private String webUploadPath;
    @RequestMapping("/save")
    public Result<List<String>> save(@RequestParam("images")MultipartFile [] images) throws IOException {
        List<String> imageList=new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            if (!images[i].isEmpty() && images[i].getSize() > 0) {
                // 获取上传的文件的名称
                String fileName = images[i].getOriginalFilename();
                // 设置文件存储位置--->当前项目的平级目录下
                // 限制文件名称最长位50，若超出截取后面部分
                if (fileName.length() > 50) {
                    fileName = fileName.substring(fileName.length() - 51);
                }
                File fileMk=new File(webUploadPath);
                if (!fileMk.exists()){
                    fileMk.mkdir();
                }
                File file = new File(webUploadPath, System.currentTimeMillis() + fileName);

                images[i].transferTo(file);
                imageList.add(file.getName());
            }
        }

        return Result.success(imageList);
    }
}

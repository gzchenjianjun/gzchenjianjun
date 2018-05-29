package com.hallom.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * @author cb
 */
@Data
public class Dynamic {
    @NotEmpty(message = "动态不能为空")
    private String dynamic;
    private List<String> imageUrlList;
    private Long schoolId;
    private String imageUrlJson;
    /**
     * 是否公开 0：不公开；1：公开
     */
    private Integer isPublic;
    private Long dynamicId;
    private Long userId;
    private Integer type;
    /**
     * 是否点赞
     */
    private Integer isFabulous;
    /**
     * 点赞数
     */
    private Integer fabulousNum;
    /**
     * 评论数
     */
    private Integer commentNum;
    /**
     * 礼物数
     */
    private Integer giftNum;
    /**
     * 头像
     */
    private String portraitUrl;

    private String username;

    private String createTime;

    private String videoPath;

}

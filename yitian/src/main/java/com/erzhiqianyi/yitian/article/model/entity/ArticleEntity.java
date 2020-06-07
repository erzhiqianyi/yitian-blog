package com.erzhiqianyi.yitian.article.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleEntity {

    private Long id;

    private String title;

    private String subTitle;

    private String keyWord;

    private String content;

    private String status;

    private String url;

    private String password;

    private String publishTrigger;

    private Long publishTime;

    private String permissionGroup;

    private String allowComment;

    private String checkComment;

    private String recommend;

    private Integer recommendPriority;


    private Long authorId;

    private Long createAt;

    private Long createBy;

    private Long updateAt;

    private Long updateBy;

}

package com.erzhiqianyi.yitian.article.model.po;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("文章配置")
@Data
public class ArticleConfig {

    @ApiModelProperty(value = "访问链接")
    private ArticleLink link;

    @ApiModelProperty(value = "发布配置")
    private ArticlePublishTrigger publish;

    @ApiModelProperty(value = "评论配置")
    private CommentConfig comment;

    @ApiModelProperty(value = "推荐配置")
    private RecommendConfig recommend;

    @ApiModelProperty(value = "访问权限")
    private AccessPermission permission;


}


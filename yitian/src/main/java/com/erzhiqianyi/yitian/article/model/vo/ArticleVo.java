package com.erzhiqianyi.yitian.article.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@ApiModel("文章")
@Data
public class ArticleVo {


    @ApiModelProperty(value = "标题")
    @NotNull(message = "标题不能为空")
    private ArticleTitle title;

    @ApiModelProperty(value = "内容")
    private ArticleContent content;

    @ApiModelProperty(value = "配置")
    private ArticleConfig config;

}

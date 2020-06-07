package com.erzhiqianyi.yitian.article.model.po;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("文章内容")
public class ArticleContent {

    @ApiModelProperty("内容")
    private String content;


}

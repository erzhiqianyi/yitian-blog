package com.erzhiqianyi.yitian.article.model.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("文章连接")
@Data
public class ArticleLink {

    @ApiModelProperty("访问链接")
    private String url;

    @ApiModelProperty("访问密码")
    private String password;
}

package com.erzhiqianyi.yitian.article.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@ApiModel("文章标题")
public class ArticleTitle {


    @NotEmpty(message = "标题不能为空")
    @Size(min = 1, max = 50, message = "标题长度为1-100")
    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "副标题")
    private String subTitle;

}

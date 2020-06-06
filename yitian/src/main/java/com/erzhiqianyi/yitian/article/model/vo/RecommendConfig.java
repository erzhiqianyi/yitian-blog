package com.erzhiqianyi.yitian.article.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("推荐配置")
@Data
public class RecommendConfig {

    @ApiModelProperty("推荐")
    private SwitchEnum recommend;

}

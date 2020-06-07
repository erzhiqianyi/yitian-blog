package com.erzhiqianyi.yitian.article.model.po;


import com.erzhiqianyi.yitian.article.model.enums.SwitchEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("推荐配置")
@Data
public class RecommendConfig {

    @ApiModelProperty("推荐")
    private SwitchEnum recommend;

    private Integer priority;

    public Integer priority() {
        if (null == priority){
            return 0;
        }else {
            return priority;
        }
    }
}

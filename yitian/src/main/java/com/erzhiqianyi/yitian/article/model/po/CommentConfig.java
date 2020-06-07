package com.erzhiqianyi.yitian.article.model.po;

import com.erzhiqianyi.yitian.article.model.enums.SwitchEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("评论配置")
@Data
public class CommentConfig {

    @ApiModelProperty("允许评论")
    private SwitchEnum allow;

    @ApiModelProperty("审核评论")
    private SwitchEnum check;
}

package com.erzhiqianyi.yitian.admin.system.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel()
@JsonInclude( JsonInclude.Include.NON_NULL)
public class SystemInfoVo {

    @ApiModelProperty(value = "博客名字")
    private String name;

    @ApiModelProperty(value = "博客域名")
    private String domain;

    public SystemInfoVo() {
    }

    public SystemInfoVo(String domain, String name) {
        this.name = name;
        this.domain = domain;
    }
}

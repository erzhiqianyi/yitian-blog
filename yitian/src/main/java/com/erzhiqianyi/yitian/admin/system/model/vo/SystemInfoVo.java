package com.erzhiqianyi.yitian.admin.system.model.vo;

import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInfoDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.Instant;

@Data
@ApiModel()
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SystemInfoVo {

    @ApiModelProperty(value = "博客名字")
    private String name;

    @ApiModelProperty(value = "博客域名")
    private String domain;

    @ApiModelProperty(value = "安装时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant installTime;

    @ApiModelProperty(value = "是否安装")
    private Boolean installed;

    public SystemInfoVo() {
    }

    public SystemInfoVo(String domain, String name) {
        this.name = name;
        this.domain = domain;
    }

    public SystemInfoVo(SystemInfoDto dto) {
        this.name = dto.getName();
        this.domain = dto.getDomain();
        this.installTime = dto.getInstallTime();
        this.installed = dto.getInstalled();
    }
}

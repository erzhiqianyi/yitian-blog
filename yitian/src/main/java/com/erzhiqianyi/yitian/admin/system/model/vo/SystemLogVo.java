package com.erzhiqianyi.yitian.admin.system.model.vo;

import com.erzhiqianyi.yitian.admin.system.model.dto.SystemLogDto;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogStatus;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@ApiModel()
@NoArgsConstructor
public class SystemLogVo {

    @ApiModelProperty(value = "操作类型")
    private LogType type;

    @ApiModelProperty(value = "状态")
    private LogStatus status;

    @ApiModelProperty(value = "操作说明")
    private String remark;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "操作时间")
    private Instant createAt;

    @ApiModelProperty(value = "操作人")
    private String createBy;

    public SystemLogVo(SystemLogDto dto) {
        this.type = dto.getType();
        this.status = dto.getStatus();
        this.remark = dto.getRemark();
        this.createAt = Instant.ofEpochMilli(dto.getCreateAt());
        switch (type){
            case LOGIN:
                this.createBy = dto.getRemark();
                break;
            default:
                this.createBy = String.valueOf(dto.getCreateBy());
        }
    }
}

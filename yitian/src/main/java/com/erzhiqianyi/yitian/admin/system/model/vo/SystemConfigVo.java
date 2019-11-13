package com.erzhiqianyi.yitian.admin.system.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@ApiModel()
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SystemConfigVo {

   @ApiModelProperty(value = "配置编码")
   private String code;

   @ApiModelProperty(value = "配置编码")
   private String name;

   @ApiModelProperty(value = "分组")
   private String parent;

   @ApiModelProperty(value = "配置值")
   private String value;

   @ApiModelProperty(value = "创建时间")
   @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
   private Instant createTime;

   @ApiModelProperty(value = "更新时间")
   @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
   private Integer updateDate;

   public SystemConfigVo(String code) {
      this.code = code;
   }
}

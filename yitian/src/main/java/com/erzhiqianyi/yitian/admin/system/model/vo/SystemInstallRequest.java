package com.erzhiqianyi.yitian.admin.system.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ApiModel()
public class SystemInstallRequest {

   @NotNull(message = "邮箱不能为空")
   @Size(min = 3, max = 50, message = "邮箱长度为3-50")
   @Email(message = "邮箱格式错误")
   @ApiModelProperty(value = "邮箱")
   private String email;

   @NotNull(message = "昵称不能为空")
   @Size(min = 2, max = 30, message = "昵称长度为2-30")
   @ApiModelProperty(value = "昵称")
   private String nickname;

   @NotNull(message = "密码不能为空")
   @Size(min = 8, max = 30, message = "密码长度为8-30")
   @ApiModelProperty(value = "密码")
   private String password;

   @NotNull(message = "域名不能为空")
   @Size(min = 2,max = 50,message = "域名长度为2-50")
   @ApiModelProperty(value = "域名")
   private String domain;


   @NotNull(message = "系统名字不能为空")
   @Size(min =1,max = 50,message = "系统名字长度为为1-50")
   @ApiModelProperty(value = "系统名字")
   private String systemName;


}

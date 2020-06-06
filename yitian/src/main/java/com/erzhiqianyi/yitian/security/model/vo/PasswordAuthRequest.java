package com.erzhiqianyi.yitian.security.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ApiModel("登录参数")
public class PasswordAuthRequest {

    @NotNull(message = "邮箱不能为空")
    @Size(min = 3, max = 50, message = "邮箱长度为3-50")
    @Email(message = "邮箱格式错误")
    @ApiModelProperty(value = "邮箱")
    private String email;


    @NotNull(message = "密码不能为空")
    @Size(min = 8, max = 30, message = "密码长度为8-30")
    @ApiModelProperty(value = "密码")
    private String password;
}

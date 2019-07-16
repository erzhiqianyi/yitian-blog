package com.erzhiqianyi.blog.model.vo.auth;

import com.erzhiqianyi.blog.model.MsgConstant;
import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ApiModel()
public class EmailRegisterRequest {

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_NAME)
    @NotNull(message = MsgConstant.EMPTY_USERNAME)
    @Size(min = 3, max = 20, message = MsgConstant.USERNAME_SIZE)
    private String name;

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_EMAIL)
    @NotNull(message = MsgConstant.EMPTY_EMAIL)
    @Size(min = 3, max = 20, message = MsgConstant.EMAIL_SIZE)
    @Email(message = MsgConstant.EMAIL_WRONG_FORMAT)
    private String email;

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_PASSWORD)
    @NotNull(message = MsgConstant.EMPTY_USERNAME)
    @Size(min = 3, max = 20, message = MsgConstant.USERNAME_SIZE)
    private String password;

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_RE_PASSWORD)
    @NotNull(message = MsgConstant.EMPTY_USERNAME)
    @Size(min = 3, max = 20, message = MsgConstant.USERNAME_SIZE)
    private String rePassword;


    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_CODE)
    @NotNull(message = MsgConstant.EMPTY_CODE)
    @Size(min = 3, max = 20, message = MsgConstant.CODE_SIZE)
    private String code;
}

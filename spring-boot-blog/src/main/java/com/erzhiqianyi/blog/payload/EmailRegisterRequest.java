package com.erzhiqianyi.blog.payload;

import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel()
public class EmailRegisterRequest {

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_NAME)
    private String name;

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_EMAIL)
    private String email;

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_PASSWORD)
    private String password;

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_RE_PASSWORD)
    private String rePassword;


    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_CODE)
    private String code;
}

package com.erzhiqianyi.blog.payload;

import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel()
public class PasswordLoginRequest {

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_NAME)
    private String username;

    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_PASSWORD)
    private String password;

}

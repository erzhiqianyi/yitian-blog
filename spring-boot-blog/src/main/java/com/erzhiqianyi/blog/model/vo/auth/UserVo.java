package com.erzhiqianyi.blog.model.vo.auth;

import com.erzhiqianyi.blog.model.dto.auth.UserDto;
import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel()
public class UserVo {
    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_ID)
    private String id;

    @ApiModelProperty(SwaggerConstant.PROPERTY_USER_NAME)
    private String name;

    @ApiModelProperty(SwaggerConstant.PROPERTY_USER_EMAIL)
    private String email;

    public UserVo() {
    }

    public UserVo(UserDto userDto) {
        this.name = userDto.getName();
        this.email = userDto.getEmail();
    }

}

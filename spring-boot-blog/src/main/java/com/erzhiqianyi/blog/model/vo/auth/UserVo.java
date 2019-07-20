package com.erzhiqianyi.blog.model.vo.auth;

import com.erzhiqianyi.blog.model.dto.auth.UserDto;
import com.erzhiqianyi.blog.model.enums.UserStatusEnum;
import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel()
@JsonInclude( JsonInclude.Include.NON_NULL)
public class UserVo {
    @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_ID)
    private String id;

    @ApiModelProperty(SwaggerConstant.PROPERTY_USER_NAME)
    private String name;

    @ApiModelProperty(SwaggerConstant.PROPERTY_USER_EMAIL)
    private String email;

    private UserStatusEnum status;

    public UserVo() {
    }

    public UserVo(UserDto userDto) {
        this.name = userDto.getName();
        this.email = userDto.getEmail();
    }

}

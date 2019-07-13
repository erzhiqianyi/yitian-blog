package com.erzhiqianyi.blog.model.vo.auth;

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

   public UserVo(EmailRegisterRequest request) {
      this.id = request.getEmail();
      this.name = request.getName();
      this.email = request.getEmail();
   }

   public UserVo(PasswordLoginRequest request) {
     this.id = request.getUsername();
     this.name = request.getUsername();
     this.email = request.getUsername();
   }
}

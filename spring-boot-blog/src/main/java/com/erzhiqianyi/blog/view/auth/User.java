package com.erzhiqianyi.blog.view.auth;

import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel()
public class User {
   @ApiModelProperty(value = SwaggerConstant.PROPERTY_USER_ID)
   private String id;

   @ApiModelProperty(SwaggerConstant.PROPERTY_USER_NAME)
   private String name;

   public User() {
   }

   public User(String id, String name) {
      this.id = id;
      this.name = name;
   }
}

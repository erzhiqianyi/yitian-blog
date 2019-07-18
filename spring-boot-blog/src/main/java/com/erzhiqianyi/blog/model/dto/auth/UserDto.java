package com.erzhiqianyi.blog.model.dto.auth;

import com.erzhiqianyi.blog.dao.entity.user.UserEntity;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String name;
    private String password;
    private String email;


    public UserDto() {
    }

    public UserDto(UserEntity user) {
        this.id = user.getId();
        this.name = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getPassword();
    }


    public UserEntity toAddEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(name);
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setCreateBy(0);
        userEntity.setUpdateBy(0);
        Long now = System.currentTimeMillis();
        userEntity.setCreateAt(now);
        userEntity.setUpdateAt(now);
        return userEntity;
    }
}

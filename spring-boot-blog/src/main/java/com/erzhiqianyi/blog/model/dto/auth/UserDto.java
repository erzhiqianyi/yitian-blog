package com.erzhiqianyi.blog.model.dto.auth;

import com.erzhiqianyi.blog.dao.entity.user.UserEntity;
import com.erzhiqianyi.blog.model.enums.UserStatusEnum;
import com.erzhiqianyi.blog.model.vo.auth.EmailRegisterRequest;
import com.erzhiqianyi.blog.model.vo.auth.PasswordLoginRequest;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private UserStatusEnum status;

    public UserDto() {
    }

    public UserDto(UserEntity user) {
        this.id = user.getId();
        this.name = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getPassword();
        this.status = UserStatusEnum.valueOf(user.getStatus());
    }

    public UserDto(EmailRegisterRequest request) {
        this.name = request.getName();
        this.password = request.getPassword();
        this.email = request.getEmail();
        this.status = UserStatusEnum.VALID;
        if (!request.getPassword().equals(request.getRePassword())) {
            throw new IllegalArgumentException();
        }
    }

    public UserDto(PasswordLoginRequest request) {
        this.email = request.getEmail();
        this.password = request.getPassword();
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
        userEntity.setStatus(status.getStatus());
        return userEntity;
    }
}

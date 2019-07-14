package com.erzhiqianyi.blog.dao.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class UserEntity {
    private Integer id ;
    private String username;
    private String email;
    private String password;
    private Long createAt;
    private String createBy;
    private String updateAt;
    private String updateBy;
}

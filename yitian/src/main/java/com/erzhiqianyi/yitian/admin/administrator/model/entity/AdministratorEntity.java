package com.erzhiqianyi.yitian.admin.administrator.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AdministratorEntity {
    private Long id;
    private String email;
    private String nickname;
    private String username;
    private String password;
    private String uuid;
    private Long createAt;
    private Long updateAt;
    private Long createBy;
    private Long updateBy;
}

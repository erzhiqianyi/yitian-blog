package com.erzhiqianyi.yitian.admin.system.model.dto;

import com.erzhiqianyi.yitian.admin.system.dao.entity.AdministratorEntity;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemInfoVo;
import lombok.Data;

import java.util.UUID;

@Data
public class AdministratorDto {
    private Long id;
    private String email;
    private String nickname;
    private String username;
    private String password;
    private String uuid;
    private Long createBy;

    public AdministratorDto(SystemInstallDto installDto) {
        this.email = installDto.getEmail();
        this.nickname = installDto.getNickname();
        this.password = installDto.getPassword();
        this.createBy = 0l;
    }

    public AdministratorEntity toAddEntity() {
        AdministratorEntity entity = new AdministratorEntity();
        entity.setEmail(this.email);
        entity.setNickname(this.nickname);
        entity.setUsername(this.getUsername());
        entity.setPassword(this.getPassword());
        entity.setUuid(UUID.randomUUID().toString());
        entity.setCreateBy(this.createBy);
        entity.setUpdateBy(this.createBy);
        entity.setCreateAt(System.currentTimeMillis());
        entity.setUpdateAt(System.currentTimeMillis());
        return entity;
    }

}

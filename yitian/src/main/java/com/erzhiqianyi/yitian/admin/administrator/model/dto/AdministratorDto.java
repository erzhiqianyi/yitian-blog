package com.erzhiqianyi.yitian.admin.administrator.model.dto;

import com.erzhiqianyi.yitian.admin.administrator.dao.entity.AdministratorEntity;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemConfigDto;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInstallDto;
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
    private Long createAt;

    public AdministratorDto(SystemInstallDto installDto) {
        this.email = installDto.getEmail();
        this.nickname = installDto.getNickname();
        this.password = installDto.getPassword();
        this.createBy = 0l;
        this.createAt = System.currentTimeMillis();
    }

    public AdministratorEntity toAddEntity() {
        AdministratorEntity entity = new AdministratorEntity();
        entity.setEmail(email);
        entity.setNickname(nickname);
        entity.setUsername(username);
        entity.setPassword(password);
        entity.setUuid(UUID.randomUUID().toString());
        entity.setCreateBy(createBy);
        entity.setUpdateBy(createBy);
        entity.setCreateAt(createAt);
        entity.setUpdateAt(createAt);
        return entity;
    }

}

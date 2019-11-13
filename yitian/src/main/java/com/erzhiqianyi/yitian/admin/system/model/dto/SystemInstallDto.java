package com.erzhiqianyi.yitian.admin.system.model.dto;

import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemConfigEntity;
import com.erzhiqianyi.yitian.admin.system.model.enums.SystemConfigEnum;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemInstallRequest;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SystemInstallDto {

    private String email;

    private String nickname;

    private String password;

    private String domain;

    private String systemName;

    public SystemInstallDto(SystemInstallRequest param) {
        this.email = param.getEmail();
        this.nickname = param.getNickname();
        this.password = param.getPassword();
        this.domain = param.getDomain();
        this.systemName = param.getSystemName();
    }

    public List<SystemConfigEntity> toSystemConfig() {
        List<SystemConfigEntity> configEntities = new ArrayList<>(3);
        SystemConfigEntity systemInfo = new SystemConfigEntity(SystemConfigEnum.SYSTEM_INFO,
                SystemConfigEnum.SYSTEM_INFO.getRemark(), SystemConfigEnum.SYSTEM_INFO);
        SystemConfigEntity installTime = new SystemConfigEntity(SystemConfigEnum.INSTALL_TIME,
                String.valueOf(System.currentTimeMillis()), SystemConfigEnum.SYSTEM_INFO);
        SystemConfigEntity domain = new SystemConfigEntity(SystemConfigEnum.DOMAIN,
                this.domain, SystemConfigEnum.SYSTEM_INFO);
        SystemConfigEntity systemName = new SystemConfigEntity(SystemConfigEnum.SYSTEM_NAME,
                this.systemName, SystemConfigEnum.SYSTEM_INFO);
        configEntities.add(systemInfo);
        configEntities.add(installTime);
        configEntities.add(domain);
        configEntities.add(systemName);
        return configEntities;
    }


}

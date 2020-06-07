package com.erzhiqianyi.yitian.admin.system.model.dto;

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


    public List<SystemConfigDto> toSystemConfig(Long createBy) {
        List<SystemConfigDto> configEntities = new ArrayList<>(3);
        SystemConfigDto systemInfo = new SystemConfigDto(SystemConfigEnum.SYSTEM_INFO,
                SystemConfigEnum.SYSTEM_INFO.getRemark(), SystemConfigEnum.SYSTEM_INFO,createBy);
        SystemConfigDto installTime = new SystemConfigDto(SystemConfigEnum.INSTALL_TIME,
                String.valueOf(System.currentTimeMillis()), SystemConfigEnum.SYSTEM_INFO,createBy);
        SystemConfigDto domain = new SystemConfigDto(SystemConfigEnum.DOMAIN,
                this.domain, SystemConfigEnum.SYSTEM_INFO,createBy);
        SystemConfigDto systemName = new SystemConfigDto(SystemConfigEnum.SYSTEM_NAME,
                this.systemName, SystemConfigEnum.SYSTEM_INFO,createBy);
        configEntities.add(systemInfo);
        configEntities.add(installTime);
        configEntities.add(domain);
        configEntities.add(systemName);
        return configEntities;
    }


}

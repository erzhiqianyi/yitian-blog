package com.erzhiqianyi.yitian.admin.system.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
public class SystemInfoDto {

    private String name;

    private String domain;

    private Instant installTime;

    private Boolean installed;

    public SystemInfoDto(SystemInstallDto dto) {
        this.name = dto.getSystemName();
        this.domain = dto.getDomain();
        this.installed = true;
        this.installTime = Instant.now();
    }

    public SystemInfoDto() {
        this.installed = false;
    }
}


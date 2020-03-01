package com.erzhiqianyi.yitian.admin.system.service;

import com.erzhiqianyi.yitian.admin.system.model.dto.SystemConfigDto;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInfoDto;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInstallDto;
import reactor.core.publisher.Mono;

public interface SystemConfigService {
    Mono<SystemInfoDto> installSystem(SystemInstallDto dto);

    Mono<SystemInfoDto> systemInfo();

    Mono<SystemConfigDto> addSystemConfig(SystemConfigDto config);
}


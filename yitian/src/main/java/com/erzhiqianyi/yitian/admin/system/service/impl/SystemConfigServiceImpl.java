package com.erzhiqianyi.yitian.admin.system.service.impl;

import com.erzhiqianyi.yitian.admin.system.repository.reactor.SystemConfigRepository;
import com.erzhiqianyi.yitian.admin.administrator.model.dto.AdministratorDto;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemConfigDto;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInfoDto;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInstallDto;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemLogDto;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogStatus;
import com.erzhiqianyi.yitian.admin.system.model.enums.LogType;
import com.erzhiqianyi.yitian.admin.system.model.enums.SystemConfigEnum;
import com.erzhiqianyi.yitian.admin.administrator.service.AdministratorService;
import com.erzhiqianyi.yitian.admin.system.service.SystemConfigService;
import com.erzhiqianyi.yitian.admin.system.service.SystemLogService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@Log4j2
public class SystemConfigServiceImpl implements SystemConfigService {

    private SystemConfigRepository systemConfigRepository;

    private AdministratorService administratorService;


    private SystemLogService logService;

    public SystemConfigServiceImpl(SystemConfigRepository systemConfigRepository,
                                   AdministratorService administratorService,
                                   SystemLogService logService) {
        this.systemConfigRepository = systemConfigRepository;
        this.administratorService = administratorService;
        this.logService = logService;
    }

    @Override
    synchronized public Mono<SystemInfoDto> installSystem(SystemInstallDto dto) {
        return systemInfo()
                .zipWith(administratorService.checkEmailExists(dto.getEmail()))
                .flatMap(tuple2 -> {
                    if (tuple2.getT1().getInstalled()) {
                        return Mono.just(tuple2.getT1());
                    }
                    if (tuple2.getT2()) {
                        throw new IllegalStateException("用户已经存在，请检查数据。");
                    }
                    return logService
                            .addSystemLog(new SystemLogDto(
                                    LogType.SYSTEM_INITIALIZATION,
                                    LogStatus.SUCCESS, null))
                            .then(administratorService.addAdministrator(new AdministratorDto(dto)))
                            .flatMapMany(administratorDto ->
                                    Flux.fromIterable(dto.toSystemConfig(administratorDto.getId())))
                            .flatMap(config -> addSystemConfig(config))
                            .then(systemInfo());
                })
                ;
    }

    @Override
    public Mono<SystemInfoDto> systemInfo() {
        SystemInfoDto dto = new SystemInfoDto();
        return systemConfigRepository.findByParent(SystemConfigEnum.SYSTEM_INFO.getCode())
                .doOnNext(item -> {
                    SystemConfigEnum configEnum = SystemConfigEnum.valueOf(item.getCode());
                    dto.setInstalled(true);
                    switch (configEnum) {
                        case DOMAIN:
                            dto.setDomain(item.getValue());
                            break;
                        case SYSTEM_NAME:
                            dto.setName(item.getValue());
                            break;
                        case INSTALL_TIME:
                            dto.setInstallTime(Instant.ofEpochMilli(Long.parseLong(item.getValue())));
                            break;
                    }
                }).then(Mono.just(dto));
    }

    @Override
    public Mono<SystemConfigDto> addSystemConfig(SystemConfigDto config) {
        return systemConfigRepository.addConfig(config.toAddEntity())
                .map(item -> {
                    config.setId(item.getId());
                    return config;
                })
                .flatMap(item -> logService.addSystemLog(SystemLogDto.addSystemConfigLog(item, LogStatus.SUCCESS)))
                .map(log -> config);

    }


}

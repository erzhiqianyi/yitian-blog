package com.erzhiqianyi.yitian.admin.system.service.impl;

import com.erzhiqianyi.yitian.admin.system.dao.reactor.SystemConfigRepository;
import com.erzhiqianyi.yitian.admin.system.model.dto.AdministratorDto;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInfoDto;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInstallDto;
import com.erzhiqianyi.yitian.admin.system.model.enums.SystemConfigEnum;
import com.erzhiqianyi.yitian.admin.system.service.AdministratorService;
import com.erzhiqianyi.yitian.admin.system.service.SystemConfigService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@Log4j2
public class SystemConfigServiceImpl implements SystemConfigService {

    private SystemConfigRepository systemConfigRepository;

    private AdministratorService administratorService;

    public SystemConfigServiceImpl(SystemConfigRepository systemConfigRepository, AdministratorService administratorService) {
        this.systemConfigRepository = systemConfigRepository;
        this.administratorService = administratorService;
    }

    @Override
    synchronized public Mono<SystemInfoDto> installSystem(SystemInstallDto dto) {
        return verifyInstall()
                .flatMap(item -> {
                    if (!item.getInstalled()) {
                        return Mono.defer(() ->
                                Mono.zip
                                        (systemConfigRepository.batchAddConfig(dto.toSystemConfig())
                                                        .then(verifyInstall()),
                                                administratorService.addAdministrator(new AdministratorDto(dto)))
                                        .map(tuple2 -> {
                                            if (tuple2.getT1().getInstalled() && null != tuple2.getT2().getId()) {
                                                return tuple2.getT1();
                                            } else {
                                                SystemInfoDto result = new SystemInfoDto();
                                                return result;
                                            }
                                        }))
                                ;
                    } else {
                        return Mono.just(item);
                    }
                });
    }


    @Override
    public Mono<SystemInfoDto> verifyInstall() {
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


}

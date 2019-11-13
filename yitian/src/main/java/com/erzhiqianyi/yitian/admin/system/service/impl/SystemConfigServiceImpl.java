package com.erzhiqianyi.yitian.admin.system.service.impl;

import com.erzhiqianyi.yitian.admin.system.dao.reactor.SystemConfigRepository;
import com.erzhiqianyi.yitian.admin.administrator.model.dto.AdministratorDto;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInfoDto;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInstallDto;
import com.erzhiqianyi.yitian.admin.system.model.enums.SystemConfigEnum;
import com.erzhiqianyi.yitian.admin.administrator.service.AdministratorService;
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
                .zipWith(administratorService.checkEmailExists(dto.getEmail()))
                .flatMap(tuple2 -> {
                    if (tuple2.getT1().getInstalled()) {
                        return Mono.just(tuple2.getT1());
                    }
                    if (tuple2.getT2()) {
                        throw new IllegalStateException("用户已经存在，请检查数据。");
                    }
                    return Mono.defer(() ->
                            administratorService.addAdministrator(new AdministratorDto(dto))
                                    .then(systemConfigRepository.batchAddConfig(dto.toSystemConfig())
                                            .doOnError(error -> log.error(error))
                                            .then(verifyInstall()))
                    );
                })
                .doOnNext(item -> log.info(item))
                ;
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

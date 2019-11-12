package com.erzhiqianyi.yitian.admin.system.service.impl;

import com.erzhiqianyi.yitian.admin.system.dao.reactor.AdministratorRepository;
import com.erzhiqianyi.yitian.admin.system.model.dto.AdministratorDto;
import com.erzhiqianyi.yitian.admin.system.service.AdministratorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.jmx.export.metadata.ManagedNotification;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class AdministratorServiceImpl implements AdministratorService {

    private AdministratorRepository repository;

    public AdministratorServiceImpl(AdministratorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<AdministratorDto> addAdministrator(AdministratorDto administratorDto) {
        return checkEmailExists(administratorDto.getEmail())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(() -> new IllegalArgumentException("用户已经存在"));
                    } else {
                        return Mono.defer(() -> repository.addAdministrator(administratorDto.toAddEntity()))
                                .doOnNext(item -> log.info(item))
                                .map(item -> {
                                    administratorDto.setId(item.getId());
                                    administratorDto.setUuid(item.getUuid());
                                    return administratorDto;
                                });
                    }
                });

    }


    @Override
    public Mono<Boolean> checkEmailExists(String email) {
        return repository.findByEmail(email)
                .map(item -> true)
                .defaultIfEmpty(false);
    }
}

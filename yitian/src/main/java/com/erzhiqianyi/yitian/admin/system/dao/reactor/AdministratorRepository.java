package com.erzhiqianyi.yitian.admin.system.dao.reactor;

import com.erzhiqianyi.yitian.admin.system.dao.entity.AdministratorEntity;
import reactor.core.publisher.Mono;

public interface AdministratorRepository {
    Mono<AdministratorEntity> addAdministrator(AdministratorEntity entity);

    Mono<AdministratorEntity> findByEmail(String email);
}

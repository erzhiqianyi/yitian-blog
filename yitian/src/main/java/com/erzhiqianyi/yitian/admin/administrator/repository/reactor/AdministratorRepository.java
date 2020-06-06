package com.erzhiqianyi.yitian.admin.administrator.repository.reactor;

import com.erzhiqianyi.yitian.admin.administrator.repository.entity.AdministratorEntity;
import reactor.core.publisher.Mono;

public interface AdministratorRepository {
    Mono<AdministratorEntity> addAdministrator(AdministratorEntity entity);

    Mono<AdministratorEntity> findByEmail(String email);
}

package com.erzhiqianyi.yitian.admin.system.repository.reactor;

import com.erzhiqianyi.yitian.admin.system.model.entity.SystemConfigEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SystemConfigRepository {

    Mono<SystemConfigEntity> findByCode(String code);

    Mono<SystemConfigEntity> addConfig(SystemConfigEntity entity);

    Flux<SystemConfigEntity> findByParent(String parent);


}

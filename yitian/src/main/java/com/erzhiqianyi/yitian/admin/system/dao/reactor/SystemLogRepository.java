package com.erzhiqianyi.yitian.admin.system.dao.reactor;

import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemLogEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SystemLogRepository {
    Mono<SystemLogEntity> addSystemLog(SystemLogEntity entity);

    Flux<SystemLogEntity> findSystemLogByPage(int index, int size);

    Mono<Integer> count();
}

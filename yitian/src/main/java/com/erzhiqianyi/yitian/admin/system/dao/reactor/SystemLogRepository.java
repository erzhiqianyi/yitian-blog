package com.erzhiqianyi.yitian.admin.system.dao.reactor;

import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemLogEntity;
import com.erzhiqianyi.yitian.admin.system.model.po.SystemLogQuery;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SystemLogRepository {
    Mono<SystemLogEntity> addSystemLog(SystemLogEntity entity);

    Flux<SystemLogEntity> findSystemLogByPage(SystemLogQuery query);

    Mono<Integer> count(SystemLogQuery query);
}

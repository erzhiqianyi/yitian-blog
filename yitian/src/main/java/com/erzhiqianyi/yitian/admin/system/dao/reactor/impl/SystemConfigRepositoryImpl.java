package com.erzhiqianyi.yitian.admin.system.dao.reactor.impl;

import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemConfigEntity;
import com.erzhiqianyi.yitian.admin.system.dao.mapper.SystemConfigMapper;
import com.erzhiqianyi.yitian.admin.system.dao.reactor.SystemConfigRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.Optional;

@Service
@Log4j2
public class SystemConfigRepositoryImpl implements SystemConfigRepository {

    private final Scheduler jdbcScheduler;

    private final SystemConfigMapper configMapper;

    public SystemConfigRepositoryImpl(Scheduler jdbcScheduler, SystemConfigMapper configMapper) {
        this.jdbcScheduler = jdbcScheduler;
        this.configMapper = configMapper;
    }

    @Override
    public Mono<SystemConfigEntity> findByCode(String code) {
        return Mono
                .defer(() -> Mono.just(configMapper.selectByCode(code)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .subscribeOn(jdbcScheduler);
    }

    @Override
    public Mono<SystemConfigEntity> addConfig(SystemConfigEntity entity) {
        return Mono.defer(() -> {
            configMapper.insert(entity);
            return Mono.just(entity);
        }).subscribeOn(jdbcScheduler);
    }

    @Override
    public Flux<SystemConfigEntity> findByParent(String parent) {
        Flux<SystemConfigEntity> defer = Flux.defer(() -> Flux.fromIterable(configMapper.selectByParent(parent)));
        return defer.subscribeOn(jdbcScheduler);
    }


}

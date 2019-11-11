package com.erzhiqianyi.yitian.admin.system.dao.reactor.impl;

import com.erzhiqianyi.yitian.admin.system.dao.entity.AdministratorEntity;
import com.erzhiqianyi.yitian.admin.system.dao.mapper.AdministratorMapper;
import com.erzhiqianyi.yitian.admin.system.dao.reactor.AdministratorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.Optional;

@Service
public class AdministratorRepositoryImpl implements AdministratorRepository {


    private final Scheduler jdbcScheduler;

    private final AdministratorMapper administratorMapper;

    public AdministratorRepositoryImpl(Scheduler jdbcScheduler, AdministratorMapper administratorMapper) {
        this.jdbcScheduler = jdbcScheduler;
        this.administratorMapper = administratorMapper;
    }


    @Override
    public Mono<AdministratorEntity> addAdministrator(AdministratorEntity entity) {
        return Mono.defer(() -> {
            administratorMapper.insert(entity);
            return Mono.just(entity);
        }).subscribeOn(jdbcScheduler);
    }

    @Override
    public Mono<AdministratorEntity> findByEmail(String email) {
        return Mono
                .defer(() -> Mono.just(administratorMapper.selectByEmail(email)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .subscribeOn(jdbcScheduler);

    }
}

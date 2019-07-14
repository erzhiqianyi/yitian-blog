package com.erzhiqianyi.blog.dao.reactor.user.impl;

import com.erzhiqianyi.blog.dao.entity.user.UserEntity;
import com.erzhiqianyi.blog.dao.mapper.user.UserMapper;
import com.erzhiqianyi.blog.dao.reactor.user.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Service
@Log4j2
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    @Qualifier("jdbcScheduler")
    private Scheduler jdbcScheduler;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Mono<UserEntity> findUserById(Integer id) {
        return Mono.justOrEmpty(id)
                .map(userId -> userMapper.selectByPrimaryKey(id))
                .subscribeOn(jdbcScheduler);
    }
}

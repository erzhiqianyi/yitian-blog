package com.erzhiqianyi.blog.dao.reactor.user.impl;

import com.erzhiqianyi.blog.dao.entity.user.UserEntityExample;
import com.erzhiqianyi.blog.dao.mapper.user.UserMapper;
import com.erzhiqianyi.blog.dao.reactor.user.UserRepository;
import com.erzhiqianyi.blog.model.dto.auth.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.util.Optional;

@Service
@Log4j2
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    @Qualifier("jdbcScheduler")
    private Scheduler jdbcScheduler;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Mono<UserDto> findUserById(Integer id) {
        return Mono.justOrEmpty(id)
                .map(userId -> userMapper.selectByPrimaryKey(id))
                .map(UserDto::new)
                .subscribeOn(jdbcScheduler);
    }

    @Override
    public Mono<UserDto> addUser(UserDto user) {
        return Mono.just(user)
                .map(UserDto::toAddEntity)
                .map(userEntity -> {
                    userMapper.insert(userEntity);
                    return new UserDto(userEntity);
                })
                .subscribeOn(jdbcScheduler);
    }

    @Override
    public Mono<UserDto> findUserByEmail(String email) {
        return Mono.justOrEmpty(email)
                .map(userEmail -> {
                    UserEntityExample example = new UserEntityExample();
                    example.createCriteria().andEmailEqualTo(userEmail);
                    return example;
                })
                .map(example -> userMapper.selectByExample(example))
                .map(userEntities ->  userEntities.stream().findFirst())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(UserDto::new)
                .subscribeOn(jdbcScheduler);

    }


}

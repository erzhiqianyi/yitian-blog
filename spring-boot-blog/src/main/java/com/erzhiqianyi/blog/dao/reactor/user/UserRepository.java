package com.erzhiqianyi.blog.dao.reactor.user;

import com.erzhiqianyi.blog.dao.entity.user.UserEntity;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<UserEntity> findUserById(Integer id);
}

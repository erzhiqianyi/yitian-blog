package com.erzhiqianyi.blog.dao.reactor.user;

import com.erzhiqianyi.blog.model.dto.auth.UserDto;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<UserDto> findUserById(Integer id);

    Mono<UserDto> addUser(UserDto user);

    Mono<UserDto> findUserByEmail(String email);
}

package com.erzhiqianyi.blog.dao.reactor.user;

import com.erzhiqianyi.blog.model.dto.auth.UserDto;
import com.erzhiqianyi.blog.model.enums.UserStatusEnum;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<UserDto> findUserById(Integer id);

    Mono<UserDto> addUser(UserDto user);

    Mono<UserDto> findUserByEmail(String email);

    void deleteUser(Integer id);

    void  updateUserStatus(Integer userId, UserStatusEnum status);
}

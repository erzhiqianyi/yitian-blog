package com.erzhiqianyi.blog.service.user;

import com.erzhiqianyi.blog.model.dto.auth.UserDto;
import com.erzhiqianyi.blog.model.enums.UserStatusEnum;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDto> addUser(UserDto addDto);

    Mono<UserDto> login(UserDto userDto);

    Mono<UserDto> deleteUser(Integer id);

    Mono<UserDto> updateUserStatus(Integer userId, UserStatusEnum status);
}

package com.erzhiqianyi.blog.service.user;

import com.erzhiqianyi.blog.model.dto.auth.UserDto;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDto> addUser(UserDto addDto);
}
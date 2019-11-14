package com.erzhiqianyi.yitian.admin.administrator.service;

import com.erzhiqianyi.yitian.security.model.bo.AuthResponse;
import com.erzhiqianyi.yitian.security.model.dto.PasswordAuthDto;
import reactor.core.publisher.Mono;

public interface AuthService {
    Mono<AuthResponse> loginByPassword(PasswordAuthDto authInfo);
}

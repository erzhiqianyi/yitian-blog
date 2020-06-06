package com.erzhiqianyi.yitian.admin.administrator.controller;


import com.erzhiqianyi.yitian.admin.administrator.service.AuthService;
import com.erzhiqianyi.yitian.security.model.bo.AuthResponse;
import com.erzhiqianyi.yitian.security.model.dto.PasswordAuthDto;
import com.erzhiqianyi.yitian.security.model.vo.PasswordAuthRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequestMapping("/api/admin/auth")
@RestController
@Api(tags = "登录")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping( value = "/login/password")
    public Mono<AuthResponse> login(@RequestBody @Valid PasswordAuthRequest request) {
        return authService.loginByPassword(new PasswordAuthDto(request.getEmail(),request.getPassword()));
    }

}

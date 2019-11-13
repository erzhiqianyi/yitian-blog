package com.erzhiqianyi.yitian.admin.administrator.controller;


import com.erzhiqianyi.yitian.admin.administrator.service.AdministratorService;
import com.erzhiqianyi.yitian.security.model.vo.AuthResponseVo;
import com.erzhiqianyi.yitian.security.model.vo.PasswordAuthRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequestMapping("/api/admin/auth")
@RestController
@Api(tags = "登录")
public class AuthController {

    private AdministratorService administratorService;

    public AuthController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @RequestMapping(value = "/login/password", method = RequestMethod.POST)
    public Mono<AuthResponseVo> login(@RequestBody @Valid PasswordAuthRequest request) {
        return Mono.empty();
    }

}

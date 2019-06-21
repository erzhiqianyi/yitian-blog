package com.erzhiqianyi.blog.controller.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/auth")
@Log4j2
@Api(value = "Swagger test Controller")
public class AuthController {

    @PostMapping("login/password")
    @ApiOperation(value = "POST Method", response = String.class)
    public Mono<String> loginByPassWord(String username,String password){
        return Mono.just("user login " + username + password);
    }
}

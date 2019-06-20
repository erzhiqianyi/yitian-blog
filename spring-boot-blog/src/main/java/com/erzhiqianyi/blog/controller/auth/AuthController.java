package com.erzhiqianyi.blog.controller.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/auth")
@Log4j2
public class AuthController {

    @PostMapping("login/password")
    public Mono<String> loginByPassWord(){
        return Mono.just("user login ");
    }
}

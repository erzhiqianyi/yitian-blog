package com.erzhiqianyi.blog.controller.auth;

import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(
            value = SwaggerConstant.VALUE_LOGIN_PASSWORD,
            tags = SwaggerConstant.TAG_LOGIN,
            consumes = SwaggerConstant.MEDIA_JSON, produces = SwaggerConstant.MEDIA_JSON,
            response = String.class
    )
    public Mono<String> loginByPassWord(String username, String password) {
        return Mono.just(username + password);
    }

    @PostMapping("login/phone")
    @ApiOperation(
            value = SwaggerConstant.VALUE_LOGIN_PHONE,
            tags = SwaggerConstant.TAG_LOGIN,
            consumes = SwaggerConstant.MEDIA_JSON, produces = SwaggerConstant.MEDIA_JSON,
            response = String.class
    )
    public Mono<String> loginByPhone(String phone) {
        return Mono.just(phone);
    }

    @PostMapping("login/email")
    @ApiOperation(
            value = SwaggerConstant.VALUE_LOGIN_EMAIL,
            tags = SwaggerConstant.TAG_LOGIN,
            consumes = SwaggerConstant.MEDIA_JSON, produces = SwaggerConstant.MEDIA_JSON,
            response = String.class
    )
    public Mono<String> loginByEmail(String email) {
        return Mono.just(email);
    }


    @PostMapping("login/third")
    @ApiOperation(
            value = SwaggerConstant.VALUE_LOGIN_THIRD,
            tags = SwaggerConstant.TAG_LOGIN,
            consumes = SwaggerConstant.MEDIA_JSON, produces = SwaggerConstant.MEDIA_JSON,
            response = String.class
    )
    public Mono<String> loginByThird(String token) {
        return Mono.just(token);
    }


}

package com.erzhiqianyi.blog.controller.auth;

import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import com.erzhiqianyi.blog.view.auth.User;
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
@Api(tags = SwaggerConstant.TAG_REGISTER)
public class RegisterController {
    @PostMapping("register")
    @ApiOperation(
            value = SwaggerConstant.VALUE_REGISTER_BY_EMAIL,
            consumes = SwaggerConstant.MEDIA_JSON,
            produces = SwaggerConstant.MEDIA_JSON,
            response = User.class
    )
    public Mono<User> loginByPassWord(String username, String password) {
        return Mono.just(new User());
    }


}

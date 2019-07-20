package com.erzhiqianyi.blog.controller.auth;

import com.erzhiqianyi.blog.model.dto.auth.UserDto;
import com.erzhiqianyi.blog.model.vo.auth.EmailRegisterRequest;
import com.erzhiqianyi.blog.service.user.UserService;
import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import com.erzhiqianyi.blog.model.vo.ResponseResult;
import com.erzhiqianyi.blog.model.vo.auth.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Log4j2
@Api(tags = SwaggerConstant.TAG_REGISTER)
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("register/email")
    @ApiOperation(
            value = SwaggerConstant.VALUE_REGISTER_BY_EMAIL,
            consumes = SwaggerConstant.MEDIA_JSON,
            produces = SwaggerConstant.MEDIA_JSON,
            response = UserVo.class
    )
    public Mono<UserVo> registerByEmail(@RequestBody @Valid EmailRegisterRequest request) {
        return userService.addUser(new UserDto(request))
                .map(UserVo::new);
    }

}

package com.erzhiqianyi.blog.controller.auth;

import com.erzhiqianyi.blog.model.MsgConstant;
import com.erzhiqianyi.blog.model.vo.ResponseResult;
import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/auth")
@Log4j2
@Api(tags = SwaggerConstant.TAG_VERIFY_CODE)
@Validated
public class VerifyCodeController {
    @GetMapping("code/email/{email}")
    @ApiOperation(
            value = SwaggerConstant.VALUE_EMAIL_CODE,
            consumes = SwaggerConstant.MEDIA_JSON,
            produces = SwaggerConstant.MEDIA_JSON,
            response = Boolean.class
    )
    public Mono<ResponseResult<Boolean>> emailVerifyCode(
            @PathVariable("email")
            @Size(min = 3, max = 20, message = MsgConstant.EMAIL_SIZE)
            @Email(message = MsgConstant.EMAIL_WRONG_FORMAT)
                    String email) {
        return Mono.just(ResponseResult.success(Boolean.TRUE));
    }

}

package com.erzhiqianyi.blog.controller.user;

import com.erzhiqianyi.blog.model.vo.ResponseResult;
import com.erzhiqianyi.blog.model.vo.auth.UserVo;
import com.erzhiqianyi.blog.service.user.UserService;
import com.erzhiqianyi.blog.swagger.SwaggerConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
@Log4j2
@Api(tags = SwaggerConstant.TAG_USER_MANAGER)
public class UserManagerController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = SwaggerConstant.VALUE_DELETE_USER,
            produces = SwaggerConstant.MEDIA_JSON,
            response = UserVo.class
    )
    public Mono<ResponseResult<UserVo>> deleteUser(@PathVariable("id") Integer id) {
        return userService.deleteUser(id)
                .map(UserVo::new)
                .map(userVo -> ResponseResult.success(userVo));
    }

}

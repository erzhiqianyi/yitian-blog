package com.erzhiqianyi.yitian.admin.system.controller;

import com.erzhiqianyi.yitian.admin.system.model.vo.SystemInfoVo;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemInstallParam;
import com.erzhiqianyi.yitian.swagger.SwaggerConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/system")
@Log4j2
@Api(tags = "系统信息")
public class SystemInfoController {

    @PostMapping("install")
    @ApiOperation(
            value = "初始化系统",
            consumes = SwaggerConstant.MEDIA_JSON,
            produces = SwaggerConstant.MEDIA_JSON,
            response = String.class
    )
    public Mono<SystemInfoVo> installSystem(@RequestBody @Valid SystemInstallParam param) {
        return Mono.just(new SystemInfoVo("www.erzhiianyi.com","二之前一的博客"));
    }

    @GetMapping("installed")
    @ApiOperation(
            value = "验证系统是否已经初始化",
            consumes = SwaggerConstant.MEDIA_JSON,
            produces = SwaggerConstant.MEDIA_JSON,
            response = String.class
    )
    public Mono<SystemInfoVo> verifyInstall(){
        return Mono.just(new SystemInfoVo());
    }
}

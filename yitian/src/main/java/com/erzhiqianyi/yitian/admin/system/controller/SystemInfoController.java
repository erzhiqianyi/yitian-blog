package com.erzhiqianyi.yitian.admin.system.controller;

import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInstallDto;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemConfigVo;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemInfoVo;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemInstallRequest;
import com.erzhiqianyi.yitian.admin.system.service.SystemConfigService;
import com.erzhiqianyi.yitian.swagger.SwaggerConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/admin/system")
@Log4j2
@Api(tags = "系统信息")
public class SystemInfoController {

    @Autowired
    private SystemConfigService systemConfigService;

    @PostMapping("install")
    @ApiOperation(
            value = "初始化系统",
            consumes = SwaggerConstant.MEDIA_JSON,
            produces = SwaggerConstant.MEDIA_JSON,
            response = SystemInfoVo.class
    )
    public Mono<SystemInfoVo> installSystem(@RequestBody @Valid SystemInstallRequest param) {
        return systemConfigService.installSystem(new SystemInstallDto(param))
                .map(SystemInfoVo::new);
    }


    @GetMapping("config/{code}")
    @ApiOperation(
            value = "查看系统配置",
            consumes = SwaggerConstant.MEDIA_JSON,
            produces = SwaggerConstant.MEDIA_JSON,
            response = SystemConfigVo.class
    )
    public Mono<SystemConfigVo> getSystemConfig(@PathVariable("code") String code){
       return Mono.just(new SystemConfigVo(code));
    }

}

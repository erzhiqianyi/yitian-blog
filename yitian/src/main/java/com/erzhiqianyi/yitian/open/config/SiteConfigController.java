package com.erzhiqianyi.yitian.open.config;

import com.erzhiqianyi.yitian.admin.system.model.vo.SystemInfoVo;
import com.erzhiqianyi.yitian.admin.system.service.SystemConfigService;
import com.erzhiqianyi.yitian.swagger.SwaggerConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/open/site")
@Log4j2
@Api(tags = "站点配置信息")
public class SiteConfigController {


    @Autowired
    private SystemConfigService systemConfigService;



    @GetMapping("/info")
    @ApiOperation(
            value = "查看博客基本信息",
            consumes = SwaggerConstant.MEDIA_JSON,
            produces = SwaggerConstant.MEDIA_JSON,
            response = SystemInfoVo.class
    )
    public Mono<SystemInfoVo> systemInfo() {
        return systemConfigService.systemInfo()
                .map(SystemInfoVo::new);
    }


}

package com.erzhiqianyi.yitian.admin.system.controller;

import com.erzhiqianyi.yitian.admin.system.model.po.SystemLogQuery;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemInfoVo;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemLogRequest;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemLogVo;
import com.erzhiqianyi.yitian.admin.system.service.SystemLogService;
import com.erzhiqianyi.yitian.common.model.vo.PageVo;
import com.erzhiqianyi.yitian.swagger.SwaggerConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/system/log")
@Log4j2
@Api(tags = "系统日志")
public class SystemLogController {

    private SystemLogService systemLogService;

    public SystemLogController(SystemLogService systemLogService) {
        this.systemLogService = systemLogService;
    }

    @GetMapping
    @ApiOperation(
            value = "分页获取日志",
            consumes = SwaggerConstant.MEDIA_JSON,
            produces = SwaggerConstant.MEDIA_JSON,
            response = SystemInfoVo.class
    )
    public Mono<PageVo<SystemLogVo>> getSystemLog(SystemLogRequest request) {
        log.info(request);
        return systemLogService.getSystemLog(request.toQuery())
                .map(pageDto -> {
                    PageVo<SystemLogVo> page =  new PageVo<>();
                    page.setTotal(pageDto.getTotal());
                    page.setResults(pageDto.getResults().stream().map(SystemLogVo::new)
                            .collect(Collectors.toList()));
                    return page;
                });
    }

}

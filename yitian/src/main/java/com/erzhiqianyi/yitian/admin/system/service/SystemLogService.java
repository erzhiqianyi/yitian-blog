package com.erzhiqianyi.yitian.admin.system.service;

import com.erzhiqianyi.yitian.admin.system.model.dto.SystemLogDto;
import com.erzhiqianyi.yitian.common.model.dto.PageDto;
import com.erzhiqianyi.yitian.common.model.vo.PaginationRequest;
import reactor.core.publisher.Mono;

public interface SystemLogService {
    Mono<SystemLogDto> addSystemLog(SystemLogDto log);

    Mono<PageDto<SystemLogDto>> getSystemLog(PaginationRequest pagination);
}

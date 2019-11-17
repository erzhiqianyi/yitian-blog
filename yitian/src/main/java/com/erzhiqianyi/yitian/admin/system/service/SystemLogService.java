package com.erzhiqianyi.yitian.admin.system.service;

import com.erzhiqianyi.yitian.admin.system.model.dto.SystemLogDto;
import reactor.core.publisher.Mono;

public interface SystemLogService {
    Mono<SystemLogDto> addSystemLog(SystemLogDto log);
}

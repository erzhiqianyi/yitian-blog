package com.erzhiqianyi.yitian.admin.system.service.impl;

import com.erzhiqianyi.yitian.admin.system.dao.reactor.SystemLogRepository;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemLogDto;
import com.erzhiqianyi.yitian.admin.system.service.SystemLogService;
import com.erzhiqianyi.yitian.common.model.dto.PageDto;
import com.erzhiqianyi.yitian.common.model.vo.PaginationRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoOperator;
import sun.print.PageableDoc;

import javax.print.attribute.standard.PresentationDirection;
import java.util.ArrayList;
import java.util.Collections;

@Service
@Log4j2
public class SystemLogServiceImpl implements SystemLogService {

    private SystemLogRepository repository;

    public SystemLogServiceImpl(SystemLogRepository repository) {
        this.repository = repository;
    }


    @Override
    public Mono<SystemLogDto> addSystemLog(SystemLogDto systemLog) {
        return repository.addSystemLog(systemLog.toAddEntity())
                .map(item -> {
                    systemLog.setId(item.getId());
                    return systemLog;
                });
    }

    @Override
    public Mono<PageDto<SystemLogDto>> getSystemLog(PaginationRequest pagination) {
        return repository.count()
                .flatMap(count -> {
                    PageDto<SystemLogDto> pageDto = new PageDto<>();
                    pageDto.setTotal(count);
                    if (count > 0 ){
                       return repository.findSystemLogByPage(pagination.start(),pagination.getSize())
                               .map(SystemLogDto::new)
                               .collectList()
                               .map(results ->  {
                                   pageDto.setResults(results);
                                   return pageDto;
                               });
                    }else {
                        return Mono.just(pageDto);
                    }
                });

    }
}

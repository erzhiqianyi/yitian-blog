package com.erzhiqianyi.yitian.admin.system.service.impl;

import com.erzhiqianyi.yitian.admin.system.model.dto.AdministratorDto;
import com.erzhiqianyi.yitian.admin.system.service.AdministratorService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Override
    public Mono<AdministratorDto> addAdministrator(AdministratorDto administratorDto) {
        administratorDto.setId(1l);
        return Mono.just(administratorDto);
    }
}

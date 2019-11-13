package com.erzhiqianyi.yitian.admin.administrator.service;

import com.erzhiqianyi.yitian.admin.administrator.model.dto.AdministratorDto;
import reactor.core.publisher.Mono;

public interface AdministratorService {
    Mono<AdministratorDto> addAdministrator(AdministratorDto administratorDto);


    Mono<Boolean> checkEmailExists(String email);
}

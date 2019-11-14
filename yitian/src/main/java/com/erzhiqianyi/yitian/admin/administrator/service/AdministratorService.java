package com.erzhiqianyi.yitian.admin.administrator.service;

import com.erzhiqianyi.yitian.admin.administrator.model.dto.AdministratorDto;
import com.erzhiqianyi.yitian.security.model.bo.PasswordAuthUser;
import reactor.core.publisher.Mono;

public interface AdministratorService {
    Mono<AdministratorDto> addAdministrator(AdministratorDto administratorDto);

    Mono<Boolean> checkEmailExists(String email);

    Mono<PasswordAuthUser> loadByEmail(String email);

}


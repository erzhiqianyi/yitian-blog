package com.erzhiqianyi.yitian.admin.administrator.service.impl;

import com.erzhiqianyi.yitian.admin.administrator.dao.reactor.AdministratorRepository;
import com.erzhiqianyi.yitian.admin.administrator.model.dto.AdministratorDto;
import com.erzhiqianyi.yitian.admin.administrator.service.AdministratorService;
import com.erzhiqianyi.yitian.security.manager.PasswordAuthenticationManager;
import com.erzhiqianyi.yitian.security.model.bo.MyPasswordEncoder;
import com.erzhiqianyi.yitian.security.model.bo.PasswordAuthUser;
import lombok.extern.log4j.Log4j2;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class AdministratorServiceImpl implements AdministratorService {

    private AdministratorRepository repository;

    private MyPasswordEncoder passwordEncoder;

    public AdministratorServiceImpl(AdministratorRepository repository, MyPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Mono<AdministratorDto> addAdministrator(AdministratorDto administratorDto) {
        return checkEmailExists(administratorDto.getEmail())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(() -> new IllegalArgumentException("用户已经存在"));
                    } else {
                        return Mono.defer(() -> Mono.just(administratorDto.toAddEntity())
                                .doOnNext(item -> item.setPassword(passwordEncoder.encode(item.getPassword())))
                                .flatMap(item -> repository.addAdministrator(item))
                                .map(item -> {
                                    administratorDto.setId(item.getId());
                                    administratorDto.setUuid(item.getUuid());
                                    return administratorDto;
                                }));
                    }
                });

    }


    @Override
    public Mono<Boolean> checkEmailExists(String email) {
        return repository.findByEmail(email)
                .map(item -> true)
                .defaultIfEmpty(false);
    }

    @Override
    public Mono<PasswordAuthUser> loadByEmail(String email) {
        return repository.findByEmail(email)
                .map(administratorEntity -> new PasswordAuthUser(administratorEntity.getUuid(),
                        administratorEntity.getPassword(), true, null
                ));
    }
}

package com.erzhiqianyi.yitian.admin.administrator.service.impl;

import com.erzhiqianyi.yitian.admin.administrator.service.AdministratorService;
import com.erzhiqianyi.yitian.admin.administrator.service.AuthService;
import com.erzhiqianyi.yitian.security.manager.PasswordAuthenticationManager;
import com.erzhiqianyi.yitian.security.model.bo.AuthResponse;
import com.erzhiqianyi.yitian.security.model.bo.AuthTokenBo;
import com.erzhiqianyi.yitian.security.model.bo.MyPasswordEncoder;
import com.erzhiqianyi.yitian.security.model.dto.PasswordAuthDto;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.temporal.ChronoUnit;

@Service
public class AuthServiceImpl implements AuthService {


    @Value("${app.jwt.expiration}")
    private long expiration;

    private AdministratorService administratorService;

    private MyPasswordEncoder passwordEncoder;


    private PasswordAuthenticationManager passwordAuthenticationManager;

    public AuthServiceImpl(AdministratorService administratorService, MyPasswordEncoder passwordEncoder, PasswordAuthenticationManager passwordAuthenticationManager) {
        this.administratorService = administratorService;
        this.passwordEncoder = passwordEncoder;
        this.passwordAuthenticationManager = passwordAuthenticationManager;
    }

    @Override
    public Mono<AuthResponse> loginByPassword(PasswordAuthDto authInfo) {
        return administratorService.loadByEmail(authInfo.getEmail()).map((userDetails) -> {
            if (passwordEncoder.matches(authInfo.getPassword(), userDetails.getPassword())) {
                AuthTokenBo authTokenBo = new AuthTokenBo(userDetails.getUsername(),
                        expiration, ChronoUnit.HOURS, null);
                return new AuthResponse(authTokenBo.token(SignatureAlgorithm.HS512,
                        passwordAuthenticationManager.getSecret()),
                        authTokenBo.getExpirationAt());
            } else {
                return new AuthResponse();
            }
        });
    }
}

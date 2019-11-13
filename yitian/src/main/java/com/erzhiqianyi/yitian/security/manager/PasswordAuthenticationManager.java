package com.erzhiqianyi.yitian.security.manager;

import com.erzhiqianyi.yitian.security.model.bo.AuthTokenBo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class PasswordAuthenticationManager implements ReactiveAuthenticationManager {


    @Value("${app.jwt.secret}")
    private String secret;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getCredentials().toString();

        AuthTokenBo tokenBo = null;
        try {
            tokenBo = new AuthTokenBo(authToken, secret);
        } catch (Exception e) {
            return Mono.empty();
        }

        if (null != tokenBo) {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    tokenBo.getUuid(),
                    null,
                    null
            );
            return Mono.just(auth);

        } else {
            return Mono.empty();
        }
    }

    public String getSecret() {
        return secret;
    }
}

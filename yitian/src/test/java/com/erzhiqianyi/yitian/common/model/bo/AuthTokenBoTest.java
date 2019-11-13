package com.erzhiqianyi.yitian.common.model.bo;

import com.erzhiqianyi.yitian.security.model.bo.AuthTokenBo;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthTokenBoTest {


    @Test
    public void token() {
        String uuid = UUID.randomUUID().toString();
        String secret = "124325546";
        AuthTokenBo tokenBo = new AuthTokenBo(uuid, 100l, ChronoUnit.SECONDS, null);
        String token = tokenBo.token(SignatureAlgorithm.HS512, secret);
        AuthTokenBo encodeBo = new AuthTokenBo(token, secret);
        assertEquals(tokenBo.getUuid(), encodeBo.getUuid());
        assertTrue(tokenBo.equals(encodeBo));

    }
}
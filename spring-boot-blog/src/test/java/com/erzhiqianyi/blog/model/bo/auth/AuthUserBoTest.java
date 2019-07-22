package com.erzhiqianyi.blog.model.bo.auth;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Log4j2
public class AuthUserBoTest {

    @Test
    public void token() {
        AuthUserBo authUser = new AuthUserBo("Test", 2, ChronoUnit.HOURS);
        String jwt = authUser.token(SignatureAlgorithm.HS512 ,"Test");
        AuthUserBo jwtUser = new AuthUserBo(jwt, "Test");
        assertTrue(authUser.equals(jwtUser));
    }
}
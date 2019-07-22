package com.erzhiqianyi.blog.model.bo.auth;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.time.temporal.ChronoUnit;

@Log4j2
public class AuthUserBoTest {

    @Test
    public void token() {
        AuthUserBo authUser = new AuthUserBo("Test", 2, ChronoUnit.HOURS);
        log.info(authUser.token("2356fd"));
    }
}
package com.erzhiqianyi.blog.controller.auth;

import com.erzhiqianyi.blog.BlogApplication;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@Log4j2
public class AuthControllerTest {
    private String loginUrl;

    @Before
    public void init() {
        loginUrl = "/api/auth/login/password";
    }

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void loginByPassWord() {
        FluxExchangeResult<String> resp =     webTestClient
                .post()
                .uri(loginUrl)
                .exchange()
                .returnResult(String.class)
        ;   
    }
}
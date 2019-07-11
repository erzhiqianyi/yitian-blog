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
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.Assert.*;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@Log4j2
public class LoginControllerTest {

    private String loginUrl;

    @Before
    public void init() {
        loginUrl = "/api/auth/register/email";
    }

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void registerByEmail() {
    }
}
package com.erzhiqianyi.blog.controller.auth;

import com.erzhiqianyi.blog.BlogApplication;
import com.erzhiqianyi.blog.model.vo.auth.EmailRegisterRequest;
import com.erzhiqianyi.blog.model.vo.auth.UserVo;
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
import reactor.core.publisher.Mono;


@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@Log4j2
public class RegisterControllerTest {

    private String registerUrl;

    @Before
    public void init() {
        registerUrl = "/api/auth/register/email";
    }

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void register() {
        EmailRegisterRequest request = new EmailRegisterRequest();
        request.setCode("1234");
        request.setName("1234");
        request.setEmail("123@123.com");
        request.setPassword("1234");
        request.setRePassword("1234");
        FluxExchangeResult<UserVo> result = webTestClient
                .post()
                .uri(registerUrl)
                .body(Mono.just(request), EmailRegisterRequest.class)
                .exchange()
                .returnResult(UserVo.class);

        result.getResponseBody().subscribe(userVo -> log.info(userVo));
    }
}
package com.erzhiqianyi.blog.controller.user;

import com.erzhiqianyi.blog.BlogApplication;
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

import static org.junit.Assert.*;


@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@Log4j2
public class UserManagerControllerTest {
    private String deleteUrl;

    @Before
    public void init() {
        deleteUrl = "/api/user";
    }

    @Autowired
    private WebTestClient webTestClient;


    @Test
    public void deleteUser() {
        Integer userId = 5;
        FluxExchangeResult<UserVo> result = webTestClient
                .delete()
                .uri(deleteUrl + "/"+userId)
                .exchange()
                .returnResult(UserVo.class);

        result.getResponseBody().subscribe(userVo -> log.info(userVo));

    }
}
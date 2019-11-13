package com.erzhiqianyi.yitian.admin.system.controller;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemInfoVo;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemInstallRequest;
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


@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@Log4j2
public class SystemInfoControllerTest {

    private String url;

    @Before
    public void init() {
        url = "/api/admin/system/install";
    }

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void installSystem() {
        SystemInstallRequest param = new SystemInstallRequest();
        param.setNickname("二之前一");
        param.setEmail("erzhiqianyi@gmail.com");
        param.setPassword("12345678");
        param.setDomain("www.erzhiqianyi.com");
        param.setSystemName("二之前一的博客");
        FluxExchangeResult<SystemInfoVo> result = webTestClient
                .post()
                .uri(url)
                .body(Mono.just(param), SystemInstallRequest.class)
                .exchange()
                .returnResult(SystemInfoVo.class);
        result.getResponseBody().subscribe(systemInfo -> log.info(systemInfo));

    }

    @Test
    public void verifyInstall() {
    }
}
package com.erzhiqianyi.yitian.admin.system.service;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemConfigEntity;
import com.erzhiqianyi.yitian.admin.system.model.dto.SystemInfoDto;
import com.erzhiqianyi.yitian.admin.system.model.enums.SystemConfigEnum;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
class SystemConfigServiceTest {

    @Autowired
    private SystemConfigService systemConfigService;

    @Test
    void install() {

    }

    @Test
    void verifyInstall() {
        StepVerifier.create(
                systemConfigService.verifyInstall()
                        .map(SystemInfoDto::getInstalled)
        )
                .expectNext(true)
                .expectComplete()
                .verify();//验证之前什么都不会执行，如果不执行verify(),不会连接数据库去查询数据。

    }
}
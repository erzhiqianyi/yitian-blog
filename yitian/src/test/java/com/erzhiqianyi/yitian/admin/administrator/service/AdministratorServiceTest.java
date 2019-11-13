package com.erzhiqianyi.yitian.admin.administrator.service;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.administrator.service.AdministratorService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;



@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class AdministratorServiceTest {

    @Autowired
    private AdministratorService administratorService;


    @Test
    public void addAdministrator() {
    }

    @Test
    public void checkEmailExists() {
        StepVerifier.create(
                administratorService.checkEmailExists("23432")
        )
                .expectNext(false)
                .expectComplete()
                .verify();//验证之前什么都不会执行，如果不执行verify(),不会连接数据库去查询数据。

        StepVerifier.create(
                administratorService.checkEmailExists("erzhiqianyi@gmail.com")
        )
                .expectNext(true)
                .expectComplete()
                .verify();//验证之前什么都不会执行，如果不执行verify(),不会连接数据库去查询数据。


    }
}
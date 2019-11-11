package com.erzhiqianyi.yitian.admin.system.dao.reactor;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.system.dao.entity.AdministratorEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;


@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class AdministratorRepositoryTest {

    @Autowired
    private AdministratorRepository repository;

    private AdministratorEntity entity;

    @Before
    public void init() {
        entity = new AdministratorEntity();
        entity.setEmail("erzhiqianyi@gmail.com");
        entity.setNickname("二之前一");
        entity.setPassword("123456789");
        entity.setCreateAt(System.currentTimeMillis());
        entity.setUpdateAt(System.currentTimeMillis());
        entity.setCreateBy(0l);
        entity.setUpdateBy(0l);

    }

    @Test
    public void addAdministrator() {
        StepVerifier.create(
                repository.addAdministrator(entity)
                        .map(AdministratorEntity::getEmail)
        )
                .expectNext(entity.getEmail())
                .expectComplete()
                .verify();//验证之前什么都不会执行，如果不执行verify(),不会连接数据库去查询数据。
    }

    @Test
    public void findByEmail() {

        StepVerifier.create(
                repository.findByEmail(entity.getEmail())
                        .map(AdministratorEntity::getEmail)
        )
                .expectNext(entity.getEmail())
                .expectComplete()
                .verify();//验证之前什么都不会执行，如果不执行verify(),不会连接数据库去查询数据。

    }
}
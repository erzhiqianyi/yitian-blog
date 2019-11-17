package com.erzhiqianyi.yitian.admin.system.dao.reactor;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemConfigEntity;
import com.erzhiqianyi.yitian.admin.system.model.enums.SystemConfigEnum;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class SystemConfigRepositoryTest {

    @Autowired
    private SystemConfigRepository repository;

    @Test
    public void findByCode() {
        String code = SystemConfigEnum.SYSTEM_INFO.getCode();
        StepVerifier.create(
                repository.findByCode(code)
                        .map(SystemConfigEntity::getCode)
        )
                .expectNext(code)
                .expectComplete()
                .verify();//验证之前什么都不会执行，如果不执行verify(),不会连接数据库去查询数据。

    }

    @Test
    public void addConfig() {
        SystemConfigEntity entity = new SystemConfigEntity();
        entity.setName(SystemConfigEnum.INSTALL_TIME.getRemark());
        entity.setCode(SystemConfigEnum.INSTALL_TIME.getCode());
        entity.setParent(SystemConfigEnum.SYSTEM_INFO.getCode());
        entity.setValue(String.valueOf(System.currentTimeMillis()));
        entity.setCreateAt(System.currentTimeMillis());
        entity.setUpdateAt(System.currentTimeMillis());
        entity.setCreateBy(1l);
        entity.setUpdateBy(1l);
        StepVerifier.create(
                repository.addConfig(entity)
                        .map(SystemConfigEntity::getCode)
        )
                .expectNext(entity.getCode())
                .expectComplete()
                .verify();//验证之前什么都不会执行，如果不执行verify(),不会连接数据库去查询数据。


    }

    @Test
    public void findByParent() {
        String parent = SystemConfigEnum.SYSTEM_INFO.getCode();

        StepVerifier.create(
                repository.findByParent(parent)
                        .map(SystemConfigEntity::getCode)
                        .sort()
        )
                .expectNext("DOMAIN", "INSTALL_TIME", "SYSTEM_INFO", "SYSTEM_NAME")
                .expectComplete()
                .verify();//验证之前什么都不会执行，如果不执行verify(),不会连接数据库去查询数据。


    }

}
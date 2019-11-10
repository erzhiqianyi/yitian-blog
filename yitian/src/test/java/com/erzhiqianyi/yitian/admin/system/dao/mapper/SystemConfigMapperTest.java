package com.erzhiqianyi.yitian.admin.system.dao.mapper;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemConfigEntity;
import com.erzhiqianyi.yitian.admin.system.model.enums.SystemConfigEnum;
import com.erzhiqianyi.yitian.admin.system.model.vo.SystemInfoVo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
class SystemConfigMapperTest {

    @Autowired
    private SystemConfigMapper systemConfigMapper;

    @Test
    void insert() {
        SystemConfigEntity entity = new SystemConfigEntity();
        entity.setName(SystemConfigEnum.SYSTEM_INFO.getRemark());
        entity.setCode(SystemConfigEnum.SYSTEM_INFO.getCode());
        entity.setParent(SystemConfigEnum.SYSTEM_INFO.getCode());
        entity.setValue("系统初始化信息");
        entity.setCreateAt(System.currentTimeMillis());
        entity.setUpdateAt(System.currentTimeMillis());
        entity.setCreateBy(1l);
        entity.setUpdateBy(1l);
        Optional<SystemConfigEntity> optional = systemConfigMapper.selectByCode(entity.getCode());
        if (!optional.isPresent()) {
            systemConfigMapper.insert(entity);
            assertNotNull(entity.getId());
        }
    }

    @Test
    public void selectByCode() {
        String code = SystemConfigEnum.SYSTEM_INFO.getCode();
        Optional<SystemConfigEntity> optional = systemConfigMapper.selectByCode(code);
        assertTrue(optional.isPresent());
        assertEquals(code, optional.get().getCode());
    }


    @Test
    public void selectByParent() {
        String parent = SystemConfigEnum.SYSTEM_INFO.getCode();
        List<SystemConfigEntity> entities = systemConfigMapper.selectByParent(parent);
        assertNotNull(entities);
        assertTrue(entities.size() > 0);
        entities.forEach(System.out::println);
    }

    @Test
    void batchInsert() {
        List<SystemConfigEntity> configEntities = new ArrayList<>(3);
        SystemConfigEntity systemInfo = new SystemConfigEntity(SystemConfigEnum.SYSTEM_INFO,
                SystemConfigEnum.SYSTEM_INFO.getRemark(), SystemConfigEnum.SYSTEM_INFO);
        SystemConfigEntity installTime = new SystemConfigEntity(SystemConfigEnum.INSTALL_TIME,
                String.valueOf(System.currentTimeMillis()), SystemConfigEnum.SYSTEM_INFO);
        SystemConfigEntity domain = new SystemConfigEntity(SystemConfigEnum.DOMAIN,
                "www.erzhiqianyi.com", SystemConfigEnum.SYSTEM_INFO);
        SystemConfigEntity systemName = new SystemConfigEntity(SystemConfigEnum.SYSTEM_NAME,
                "二之前一的博客", SystemConfigEnum.SYSTEM_INFO);
        configEntities.add(systemInfo);
        configEntities.add(installTime);
        configEntities.add(domain);
        configEntities.add(systemName);
        systemConfigMapper.batchInsert(configEntities);
        Stream.of(SystemConfigEnum.SYSTEM_INFO, SystemConfigEnum.SYSTEM_NAME, SystemConfigEnum.INSTALL_TIME,
                SystemConfigEnum.DOMAIN)
                .map(SystemConfigEnum::getCode)
                .forEach(item -> {
                    Optional<SystemConfigEntity> optional = systemConfigMapper.selectByCode(item);
                    assertTrue(optional.isPresent());
                });

    }
}
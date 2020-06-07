package com.erzhiqianyi.yitian.admin.system.repository.mapper;


import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.system.model.entity.SystemConfigEntity;
import com.erzhiqianyi.yitian.admin.system.model.enums.SystemConfigEnum;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class SystemConfigMapperTest {

    @Autowired
    private SystemConfigMapper systemConfigMapper;

    @Test
    public void insert() {
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


}
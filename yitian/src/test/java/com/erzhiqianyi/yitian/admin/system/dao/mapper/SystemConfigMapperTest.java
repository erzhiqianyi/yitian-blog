package com.erzhiqianyi.yitian.admin.system.dao.mapper;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.system.dao.entity.SystemConfigEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.nio.file.OpenOption;
import java.util.Optional;

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
        entity.setName("博客名字");
        entity.setCode("SYSTEM_NAME");
        entity.setValue("二之前一的博客");
        entity.setCreateAt(System.currentTimeMillis());
        entity.setUpdateAt(System.currentTimeMillis());
        entity.setCreateBy(1l);
        entity.setUpdateBy(1l);
        Optional<SystemConfigEntity> optional = systemConfigMapper.selectByCode(entity.getCode());
        if (!optional.isPresent()) {
            Integer id = systemConfigMapper.insert(entity);
            assertNotNull(id);
        }
    }

    @Test
    public void selectByCode() {
        String code = "SYSTEM_NAME";
        Optional<SystemConfigEntity> optional = systemConfigMapper.selectByCode("SYSTEM_NAME");
        assertTrue(optional.isPresent());
        assertEquals(code,optional.get().getCode());


    }


}
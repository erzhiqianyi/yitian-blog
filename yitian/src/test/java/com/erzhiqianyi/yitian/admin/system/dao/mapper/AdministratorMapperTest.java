package com.erzhiqianyi.yitian.admin.system.dao.mapper;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.system.dao.entity.AdministratorEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
class AdministratorMapperTest {

    @Autowired
    private AdministratorMapper mapper;

    @Test
    void insert() {
        AdministratorEntity administratorEntity = new AdministratorEntity();
        administratorEntity.setEmail("erzhiqianyi@gmail.com");
        administratorEntity.setNickname("二之前一");
        administratorEntity.setUsername("erzhiqianyi");
        administratorEntity.setPassword("12345678");
        administratorEntity.setCreateAt(System.currentTimeMillis());
        administratorEntity.setUpdateAt(System.currentTimeMillis());
        administratorEntity.setCreateBy(0l);
        administratorEntity.setUpdateBy(0l);
        Optional<AdministratorEntity> optional = mapper.selectByEmail(administratorEntity.getEmail());
        if (!optional.isPresent()) {
            mapper.insert(administratorEntity);
            assertNotNull(administratorEntity.getId());
        }

    }

    @Test
    void selectByEmail() {
        String email = "erzhiqianyi@gmail.com";
        Optional<AdministratorEntity> optional = mapper.selectByEmail(email);
        assertTrue(optional.isPresent());
        assertEquals(email, optional.get().getEmail());

    }
}
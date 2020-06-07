package com.erzhiqianyi.yitian.admin.administrator.repository.mapper;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.admin.administrator.model.entity.AdministratorEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;


@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class AdministratorMapperTest {

    @Autowired
    private AdministratorMapper mapper;

    @Test
    public void insert() {
        AdministratorEntity administratorEntity = new AdministratorEntity();
        administratorEntity.setEmail("erzhiqianyi@gmail.com");
        administratorEntity.setNickname("二之前一");
        administratorEntity.setUsername("erzhiqianyi");
        administratorEntity.setPassword("12345678");
        administratorEntity.setUuid(UUID.randomUUID().toString());
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
    public void selectByEmail() {
        String email = "erzhiqianyi@gmail.com";
        Optional<AdministratorEntity> optional = mapper.selectByEmail(email);
        assertTrue(optional.isPresent());
        assertEquals(email, optional.get().getEmail());

    }
}
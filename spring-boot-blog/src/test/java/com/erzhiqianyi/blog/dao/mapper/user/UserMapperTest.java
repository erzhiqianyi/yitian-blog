package com.erzhiqianyi.blog.dao.mapper.user;

import com.erzhiqianyi.blog.BlogApplication;
import com.erzhiqianyi.blog.dao.entity.user.UserEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectById() {
        Optional<UserEntity> optional = userMapper.selectById(1);
        assertTrue(optional.isPresent());
    }
}
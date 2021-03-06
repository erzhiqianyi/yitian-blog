package com.erzhiqianyi.blog.dao.mapper.user;

import com.erzhiqianyi.blog.BlogApplication;
import com.erzhiqianyi.blog.dao.entity.user.UserEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectById() {
        log.info("执行测试");
        UserEntity userEntity = userMapper.selectByPrimaryKey(1);
        assertNotNull(userEntity);
    }
}
package com.erzhiqianyi.blog.dao.reactor.user.impl;

import com.erzhiqianyi.blog.BlogApplication;
import com.erzhiqianyi.blog.dao.entity.user.UserEntity;
import com.erzhiqianyi.blog.dao.reactor.user.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class UserRepositoryImplTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserById() {
        log.info("执行测试");
        StepVerifier.create(
                userRepository.findUserById(1)
                        .map(UserEntity::getUsername)
        )
                .expectNext("admin")
                .expectComplete()
                .verify();
    }

}
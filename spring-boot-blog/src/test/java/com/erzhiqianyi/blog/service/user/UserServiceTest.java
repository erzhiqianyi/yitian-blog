package com.erzhiqianyi.blog.service.user;

import com.erzhiqianyi.blog.BlogApplication;
import com.erzhiqianyi.blog.model.dto.auth.UserDto;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import static org.junit.Assert.*;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class UserServiceTest {


    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        UserDto userDto = new UserDto();
        userService.addUser(userDto);

        StepVerifier.create(
                userService.addUser(userDto)
        )
                .assertNext(user -> assertNotNull(user.getId()))
                .verifyComplete();

    }
}
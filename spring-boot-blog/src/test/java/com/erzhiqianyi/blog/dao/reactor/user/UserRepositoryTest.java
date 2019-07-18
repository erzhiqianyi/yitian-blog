package com.erzhiqianyi.blog.dao.reactor.user;

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
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserById() {
        Integer id = 1;
        StepVerifier.create(userRepository.findUserById(id))
                .assertNext(user -> {
                            assertNotNull(user);
                            assertEquals(id, user.getId());
                        }
                )
                .verifyComplete();
    }


    @Test
    public void addUser() {
        UserDto userDto = new UserDto();
        userDto.setEmail("123@1234.com");
        userDto.setName("测试");
        userDto.setPassword("123456");
        StepVerifier.create(userRepository.addUser(userDto))
                .assertNext(user -> {
                            assertNotNull(user.getId());
                        }
                )
                .verifyComplete();

    }
}
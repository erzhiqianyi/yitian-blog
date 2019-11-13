package com.erzhiqianyi.yitian.security.model.bo;

import com.erzhiqianyi.yitian.YitianApplication;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class MyPasswordEncoderTest {

    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Test
    public void encode() {
        String password = "234354645";
        String encoded = myPasswordEncoder.encode(password);
        log.info(encoded);
        assertTrue(myPasswordEncoder.matches(password,encoded));

    }


}
package com.codingstudy.login.components;

import com.codingstudy.login.service.JwtUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtTokenUtilTest {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Test
    void generateToken() {

        UserDetails userDetails = new JwtUser("ming206","123456",1,null);

        String token = jwtTokenUtil.generateToken(userDetails);

        System.out.println("token = " + token);
    }

    @Test
    void getUsernameFromToken() {
    }

    @Test
    void validateToken() {
    }
}
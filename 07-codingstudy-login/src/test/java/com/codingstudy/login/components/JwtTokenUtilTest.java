package com.codingstudy.login.components;

import com.codingstudy.login.service.JwtUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;


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
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1ODU4MzcwNTIsInN1YiI6Im1pbmcyMDYiLCJpYXQiOjE1ODMyNDUwNTI2ODN9.OTNcwBfK2MYoA1pufz8FQnd4fO_2ZIpdTgiP6lPQD0VY02-IqnMnRP1EHb6lz3wG1I9lcqZj60o6EhdP6HQIvA";
        String username =  jwtTokenUtil.getUsernameFromToken(token);
        System.out.println("username = " + username);
    }

    @Test
    void validateToken() {
    }
}
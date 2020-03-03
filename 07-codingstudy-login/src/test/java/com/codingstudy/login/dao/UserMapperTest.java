package com.codingstudy.login.dao;

import com.codingstudy.login.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper mapper;

    @Test
    void test01() {
       List<UserEntity> list =  mapper.selectList(null);
        System.out.println(list);
    }
}
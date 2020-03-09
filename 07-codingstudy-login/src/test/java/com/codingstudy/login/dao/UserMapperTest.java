package com.codingstudy.login.dao;

import com.codingstudy.login.entity.SysUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class UserMapperTest {

    @Autowired
    SysUserMapper mapper;

    @Test
    void test01() {
       List<SysUserEntity> list =  mapper.selectList(null);
        System.out.println(list);
    }
}
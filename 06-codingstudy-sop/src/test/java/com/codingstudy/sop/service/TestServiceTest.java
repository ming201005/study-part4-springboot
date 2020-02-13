package com.codingstudy.sop.service;

import com.codingstudy.sop.aspect.LogAnnotation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.Name;
import java.util.Map;

@SpringBootTest
class TestServiceTest {

    @Autowired
    TestService testService ;

    @Test
    void test01(){
        Map<String,Object> rs =  testService.getUser(100,"张三",25);

        System.out.println("test rs = " +rs);
    }

    @Test
    @LogAnnotation
    void test02(){
        System.out.println("test02-----------------------");
    }
}
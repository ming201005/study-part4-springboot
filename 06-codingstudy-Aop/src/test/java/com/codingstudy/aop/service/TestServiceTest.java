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
        Map<String,Object> user =  testService.getUser(2);

        System.out.println("user==》 " +user);
    }

    @Test
    void test02(){
        Map<String,Object> user =  testService.getUser02(5);

        System.out.println("user==》 " +user);
    }
}
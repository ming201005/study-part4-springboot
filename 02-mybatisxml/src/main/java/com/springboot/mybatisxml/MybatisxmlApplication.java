package com.springboot.mybatisxml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.springboot.mybatisxml.dao")
//同等于在每个Dao层加@Mapper注解
public class MybatisxmlApplication {

    public static void main(String[] args) {
        SpringApplication.run (MybatisxmlApplication.class, args);
    }

}

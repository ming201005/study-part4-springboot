package com.springboot.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.springboot.mybatisplus.mapper")
//开启支持异步调用
@EnableAsync
public class MybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run (MybatisplusApplication.class, args);
    }

}

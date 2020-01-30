package com.codingstudy.ajax.ajax;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.codingstudy.ajax.ajax.dao")
public class AjaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(AjaxApplication.class, args);
    }

}

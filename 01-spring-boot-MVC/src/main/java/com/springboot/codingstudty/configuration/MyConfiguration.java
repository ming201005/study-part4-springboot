package com.springboot.codingstudty.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：配置beans
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-13 11:22
 * @see
 */
@Configuration
public class MyConfiguration {
    //默认
    @Bean
    UserAction userAction(){
        System.out.println ("默认名字是userAction");
        return new UserAction();
    }


    @Bean(value = "userAction1")
    UserAction userAction1(){
        System.out.println ("名字为userAction1");
        return new UserAction();
    }
}

package com.springboot.codingstudty.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {
    @Value("${server.port}")
    public  String  port;

    public static  String DATA_SOURCE_URL;

    /**
     * @value给静态变量赋值，需要增加set方法
     * 方法名称和参数可任意。
     * @param val
     */
    @Value ("${spring.datasource.url}")
    public void setDataSourceUrl(String val){
        DATA_SOURCE_URL = val;
    }

    @GetMapping("val")
    public String getVal(){
        return "端口号="+ port+",DataSource URL ="+DATA_SOURCE_URL;
    }

}

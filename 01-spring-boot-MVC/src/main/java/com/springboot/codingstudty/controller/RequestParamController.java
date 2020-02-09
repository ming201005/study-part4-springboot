package com.springboot.codingstudty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 @RequestParam
 */
@RestController
public class RequestParamController {

    @GetMapping("param")
    public String param(
            @RequestParam("id") String id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "age", required = false) int age) {
        String data = "";
        try {
            //返回ID，NAME，age
            data = "id=" + id + "，name=" + name + "，age=" + age;
        } catch (Exception e) {
            data = e.getMessage();
        }
        return data;
    }
}

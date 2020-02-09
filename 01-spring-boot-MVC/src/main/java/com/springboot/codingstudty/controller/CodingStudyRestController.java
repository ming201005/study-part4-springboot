package com.springboot.codingstudty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
/**
 * 测试 @RestController
 */
@RestController
public class CodingStudyRestController {
    /**
     * 假设是获取用户信息
     * @return
     */
    @GetMapping("user")
    public Map<String,Object> getUser() {
        //模拟一个用户
        Map<String,Object> user = new HashMap<>();
        user.put ("id",1);
        user.put ("name","张三");
        user.put ("age",18);
        //返回这个用户
        return user;
    }

}

package com.codingstudy.login.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.codingstudy.login.entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 登录接口
 */
@RestController
@RequestMapping("register")
public class UserController {

    @PostMapping
    public R<String> register(@RequestBody(required = false) UserEntity userEntity){

        return R.ok("注册成功");
    }
}

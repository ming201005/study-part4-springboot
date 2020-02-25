package com.codingstudy.aop.service;

import com.codingstudy.aop.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void  test01() {

        userService.addUser(100,"张三",true);

    }

    @Test
    void  test02() {
        User user = new User(100,"张三","男");
        User u = userService.editUser(user);
        System.out.println("---------------------------------结果---------------------------------------");
        System.out.println(u);
    }
}
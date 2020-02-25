package com.codingstudy.aop.cglib;

import com.codingstudy.aop.service.UserService;
import org.junit.jupiter.api.Test;



class CGProxyTest {

    @Test
    void  test01() {
      UserService service =  new CGProxy<UserService>(new UserService()).getProxy();
      service.addUser(10000,"李兰",false);
    }

}
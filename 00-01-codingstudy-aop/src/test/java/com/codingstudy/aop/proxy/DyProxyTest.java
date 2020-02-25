package com.codingstudy.aop.proxy;

import com.codingstudy.aop.proxy.impl.TeacherImpl;
import com.codingstudy.aop.service.IUser;
import com.codingstudy.aop.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DyProxyTest {

    @Test
    void  test01(){
       Teacher teacher = (Teacher)  new DyProxy(new TeacherImpl()).getProxy();
       teacher.teach("胡老师。。。。。。。");

    }

    @Test
    void  test02() {
        IUser service = (IUser)new DyProxy(new UserService()).getProxy();
        service.addUser(12,"张三",true);
    }
}
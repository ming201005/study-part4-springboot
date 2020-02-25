package com.codingstudy.aop.service;

import com.codingstudy.aop.aspects.LogAnnotation;
import com.codingstudy.aop.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbsUserService implements IUser {

    @LogAnnotation(value = "add",description = "创建用户信息")
    public  void addUser(int id,String name,boolean flag) {
        //before();
        System.out.println("这个方法是UserSerive中的AddUser方法");
        System.out.println("user name ===>"+name);
        //after();
    }

    @LogAnnotation(value = "edit",description = "用户修改")
    public User editUser(User user) {
        before();
        int a= 0;
        int b =2;
        int c = b/a;

        System.out.println("-------editUser.....");
        User user1 = user;
        after();
        return user1;

    }
}

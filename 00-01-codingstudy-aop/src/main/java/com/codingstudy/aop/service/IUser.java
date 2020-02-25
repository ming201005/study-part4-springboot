package com.codingstudy.aop.service;

import com.codingstudy.aop.aspects.LogAnnotation;
import com.codingstudy.aop.entity.User;

public interface IUser {

    public  void addUser(int id,String name,boolean flag) ;

    public User editUser(User user);
}

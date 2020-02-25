package com.codingstudy.aop.proxy.impl;


import com.codingstudy.aop.proxy.Teacher;

/**
 * 老师实现类
 */
public class TeacherImpl implements Teacher {
    @Override
    public void teach(String name) {
        System.out.println("我是["+name+"]老师。。。。。。");
        this.teachEn();
    }

    private void teachEn() {
        System.out.println("我是教英语的。。。。。。。。");
    }
}

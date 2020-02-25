package com.codingstudy.aop.proxy;

import com.codingstudy.aop.proxy.impl.TeacherImpl;

/**
 * 老师代理类
 */
public class TeacherProxy implements Teacher {
    private TeacherImpl teacher;

    public TeacherProxy(TeacherImpl teacher) {
        this.teacher = teacher;
    }

    @Override
    public void teach(String name) {
        before();
        this.teacher.teach(name);
        after();
    }

    void  before()
    {
        System.out.println("before ...................");
    }

    void after() {
        System.out.println("after .....................");
    }
}

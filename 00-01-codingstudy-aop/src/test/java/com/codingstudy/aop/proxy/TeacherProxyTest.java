package com.codingstudy.aop.proxy;

import com.codingstudy.aop.proxy.impl.TeacherImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TeacherProxyTest {

    @Test
    void teach() {
        Teacher teacher = new TeacherProxy(new TeacherImpl());
        teacher.teach("何炅");
    }
}
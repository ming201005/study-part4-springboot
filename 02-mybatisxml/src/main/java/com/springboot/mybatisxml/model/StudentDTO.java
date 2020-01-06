package com.springboot.mybatisxml.model;

import com.springboot.mybatisxml.model.Grade;
import com.springboot.mybatisxml.model.Student;

import java.util.List;

/**
 * 描述：定义一个StudentDTO 数据转换类
 * @author ming
 * @version 1.0
 * @date 2019-12-22 22:47
 * @see
 */
public class StudentDTO extends Student {

    //年级
    Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "grade=" + grade.toString () +
                 ","+super.toString ()+
                '}';
    }
}

package com.springboot.mybatisxml.model;

import com.springboot.mybatisxml.model.Grade;
import com.springboot.mybatisxml.model.Student;

import java.util.List;

/**
 * 描述：年级——学生关系类
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-22 23:28
 * @see
 */
public class GradeDTO extends Grade {

    //学生。一个年级有多个学生。所以下面是用List存储
    List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}

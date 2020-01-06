package com.springboot.mybatis03.model;

import java.util.List;

/**
 * 描述：年级->学生 1对多关系
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-24 23:20
 * @see
 */
public class GradeDTO  extends Grade {

    List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        String studentStr = "";
        for (Student student:students){
            studentStr += "\n" + student.toString ();
        }
        return "GradeDTO{" +
                super.toString ()+
                studentStr +
                '}';
    }
}

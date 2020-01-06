package com.springboot.mybatisxml.model;

import java.util.Set;

/**
 * 描述：课程和学生关系
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-23 12:31
 * @see StudentCourseDTO 注意他们是多对多关系
 */
public class CourseStudentGradeDTO extends Course {

    //学生信息
    private Set<StudentDTO> studentList;

    public Set<StudentDTO> getStudents() {
        return studentList;
    }

    public void setStudents(Set<StudentDTO> studentList) {
        this.studentList = studentList;
    }

}

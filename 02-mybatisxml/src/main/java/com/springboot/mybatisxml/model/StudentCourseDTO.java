package com.springboot.mybatisxml.model;

import java.util.Set;

/**
 * 描述：从学生反查课程、年级。
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-23 16:57
 * @see CourseStudentDTO 注意他们是多对多关系
 */
public class StudentCourseDTO  extends Student {

    //选修课
    Set<CourseStudentDTO> courseList;

    public Set<CourseStudentDTO> getCourseList() {
        return courseList;
    }

    public void setCourseList(Set<CourseStudentDTO> courseList) {
        this.courseList = courseList;
    }
}

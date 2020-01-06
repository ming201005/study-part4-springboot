package com.springboot.mybatisxml.model;

/**
 * 描述：课程
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-23 12:29
 * @see
 */
public class Course {
    Integer id;

    String courseName;

    public Course() {
    }

    public Course(Integer id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}

package com.springboot.mybatis03.model;

import java.util.List;

/**
 * 描述：学生、年级
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-24 22:50
 * @see
 */
public class StudentDTO extends  Student {

    //一个学生，只能是某个年级，1：1关系
    Grade grade;

    //一个学生，选择多个课程，1：n关系
    //这是做学生和课程n：m关系时加的属性
    List<CourseDTO> courses;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "  id=" + id +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", addr='" + addr + '\'' +
                ", gradeId=" + gradeId +
                "  grade=" + grade+
                "  courses"+courses+
                '}';
    }
}

package com.springboot.mybatisplus.entity;

/**
 * 描述：学生信息+年级
 *
 * @author ming
 * @version 1.0
 * @date 2020-01-02 20:00
 * @see
 */
public class StudentDTO extends  Student {

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
                "grade=" + grade +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", gradeEnum=" + gradeId +
                '}';
    }


    public String display() {
        return super.toString ();
    }
}

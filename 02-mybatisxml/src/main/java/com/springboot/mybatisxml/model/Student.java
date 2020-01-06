package com.springboot.mybatisxml.model;

/**
 * 描述： 学生信息表
 * @author ming
 * @version 1.0
 * @date 2019-12-19 17:55
 * @see
 */
public class Student  {

    Integer id;
    String  studentName;
    Integer age;
    char    sex;
    String  addr;
    Integer gradeId;

    public Student() {
    }

    public Student(Integer id, String studentName, Integer age, char sex, String addr, Integer gradeId) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.addr = addr;
        this.gradeId = gradeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", addr='" + addr + '\'' +
                ", gradeId=" + gradeId +
                '}';
    }
}

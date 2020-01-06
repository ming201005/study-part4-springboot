package com.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.springboot.mybatisplus.enums.GradeEnum;

/**
 * 描述：学生实体类,为了测试枚举
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-29 16:02
 * @see
 */
@TableName(value = "student")
public class StudentTESTENUM {
    //唯一ID
    @TableId(value = "id",type = IdType.AUTO)
    Integer id;
    @TableField(value = "student_name")
    String name;
    String sex;
    Integer age;

    String addr;

    //数据库不存储该值
    @TableField(exist = false)
    String description;

    @TableField(value = "grade_id")
    GradeEnum gradeEnum;


    public StudentTESTENUM() {
    }

    public StudentTESTENUM(Integer id, String name, String sex, Integer age, String addr, GradeEnum gradeId) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
        this.gradeEnum = gradeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public GradeEnum getGradeEnum() {
        return gradeEnum;
    }

    public void setGradeEnum(GradeEnum gradeEnum) {
        this.gradeEnum = gradeEnum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", gradeEnum=" + gradeEnum +
                '}';
    }
}

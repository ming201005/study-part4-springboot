package com.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 描述：学生实体类
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-29 16:02
 * @see
 */
@TableName(value = "student")
public class StudentAR extends Model<StudentAR> {
    //唯一ID
    @TableId(value = "id",type = IdType.AUTO)
    Integer id;
    @TableField(value = "student_name")
    String name;
    String sex;
    Integer age;
    String addr;
    Integer gradeId;

    public StudentAR() {

    }

    public StudentAR(Integer id, String name, String sex, Integer age, String addr, Integer gradeId) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
        this.gradeId = gradeId;
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
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", gradeId=" + gradeId +
                '}';
    }
}

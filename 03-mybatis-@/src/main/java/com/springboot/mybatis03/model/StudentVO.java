package com.springboot.mybatis03.model;

/**
 * 描述： 学生信息表 VO
 * 希望直接展现给客户的数据
 * @author ming
 * @version 1.0
 * @date 2019-12-19 17:55
 * @see
 */
public class StudentVO {

    Integer id;
    String  name;
    Integer age;
    String  sex;

    public StudentVO() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(char sex) {
        if('男'==sex) {
            this.sex = "帅哥";
        }else if('女'==sex){
            this.sex = "美女";
        }else {
            this.sex = "保密";
        }
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

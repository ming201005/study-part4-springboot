package com.springboot.mybatisplus.entity;

/**
 * 描述：视图层显示对象
 *
 * @author ming
 * @version 1.0
 * @date 2020-01-02 17:19
 * @see
 */
public class StudentVO {
    Integer id;
    String  name;
    Integer age;
    String  sex;

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

    public void setSex(String sex) {
        if ("男".equals (sex)) {
            this.sex = "靓仔";
        }else if ("女".equals (sex)) {
            this.sex = "靓女";
        }else{
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

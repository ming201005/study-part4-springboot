package com.springboot.mybatisxml.model;

/**
 * 年级信息表(Grade)表实体类
 *
 * @author makejava
 * @since 2019-12-22 22:44:43
 */

public class Grade {

    //主键    
    private Integer id;
    //年级    
    private String gradeName;

    public Grade() {
    }

    public Grade(Integer id, String gradeName) {
        this.id = id;
        this.gradeName = gradeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
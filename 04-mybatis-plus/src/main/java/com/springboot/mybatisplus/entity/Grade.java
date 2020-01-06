package com.springboot.mybatisplus.entity;

import java.util.List;

/**
 * 描述：年级
 *
 * @author ming
 * @version 1.0
 * @date 2020-01-02 19:58
 * @see
 */
public class Grade {

    Integer id;
    String  gradeName;

    List<StudentDTO> studentDTOList;

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

    public List<StudentDTO> getStudentDTOList() {
        return studentDTOList;
    }

    public void setStudentDTOList(List<StudentDTO> studentDTOList) {
        this.studentDTOList = studentDTOList;
    }

    @Override
    public String toString() {
        return "Grade{" +
                   display () + '\'' +
                ", studentDTOList=" + studentDTOList +
                '}';
    }

    public String display() {
        return "Grade{" +
                "id=" + id +
                ", gradeName='" + gradeName +
                '}';
    }
}

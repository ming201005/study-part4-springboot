package com.springboot.mybatis03.model;

import java.util.List;

/**
 * 描述：课程
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-25 10:13
 * @see
 */
public class CourseDTO extends  Course {

    //课程,学生1：n
    List<StudentDTO> studentsList;

    @Override
    public String toString() {

        return "CourseDTO{" +
                super.toString ()+
                "\n"+studentsList+
                '}';
    }
}

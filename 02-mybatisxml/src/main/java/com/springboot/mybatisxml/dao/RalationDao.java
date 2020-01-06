package com.springboot.mybatisxml.dao;

import com.springboot.mybatisxml.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * 描述：关联关系示例
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-22 23:16
 * @see
 */
@Mapper
public interface RalationDao {

    //1:1 关联查询学生及所在的班级
    List<StudentDTO> getStudents();

    //1：n 关联查询班级和班级下的学生
    Set<GradeDTO> getGrades();

    //n：m 3表关联：查询课程，并带出学生（课程、中间表、学生3张表）
    Set<CourseStudentDTO> getCourseStudent();

    //n:m 3表关联：查询学生，并带出选修课程（课程、中间表、学生3张表）
    Set<StudentCourseDTO> getStudentCourse();

    //更多 4表关联：查询课程，并带出学生和所在年级（课程、中间表、学生、年级 4张表）
    Set<CourseStudentGradeDTO> getCourseStudent4();
}

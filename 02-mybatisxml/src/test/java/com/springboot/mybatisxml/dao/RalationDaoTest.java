package com.springboot.mybatisxml.dao;

import com.springboot.mybatisxml.model.*;
import com.springboot.mybatisxml.model.CourseStudentDTO;
import com.springboot.mybatisxml.model.GradeDTO;
import com.springboot.mybatisxml.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Set;

/**
 * 描述：直接测试dao层的接口方法
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-22 23:19
 * @see
 */
@SpringBootTest
class RalationDaoTest {

    @Autowired
    RalationDao ralationDao;

    //测试学生关联年级
    @Test
    void getStudents()
    {
        List<StudentDTO> list = ralationDao.getStudents ();
        //打印结果
        list.forEach (System.out::println);
    }

    //年级-学生关联查询
    @Test
    void getGrades()
    {
        Set<GradeDTO> list = ralationDao.getGrades ();
        //打印结果
        for(GradeDTO grade  : list){
            System.out.println (grade);
            //得到该年级下的所有学生列表
            List<Student> studentList = grade.getStudentList ();
            for (Student student : studentList) {
                System.out.println ("----->"+student);
            }
        }
    }

    //3表关联：查询课程，并带出学生（课程、中间表、学生3张表）
    @Test
    void getCourseStudent() {

        Set<CourseStudentDTO> list =  ralationDao.getCourseStudent();
        //打印结果
        for(CourseStudentDTO courseList  : list){
            System.out.println (courseList);
            //选修这门课的所有学生
            Set<StudentCourseDTO> studentList = courseList.getStudents ();
            for (Student student : studentList) {
                System.out.println ("----->"+student);
            }
        }
    }

    //3表关联：查询学生，并带出选修课程（课程、中间表、学生3张表）
    @Test
    void getStudentCourse() {

        Set<StudentCourseDTO> list =  ralationDao.getStudentCourse ();
        //打印结果
        for(StudentCourseDTO students  : list){
            System.out.println (students);
            //选修这门课的所有学生
            Set<CourseStudentDTO> courseList = students.getCourseList ();
            for (Course course : courseList) {
                System.out.println ("----->"+course);
            }
        }
    }



    //4表关联：查询课程，并带出学生（课程、中间表、学生3张表）
    @Test
    void getCourseStudent4() {

        Set<CourseStudentGradeDTO> list =  ralationDao.getCourseStudent4();
        //打印结果
        for(CourseStudentGradeDTO courseStudentDTO  : list){
            System.out.println (courseStudentDTO);
            //选修这门课的所有学生
            Set<StudentDTO> studentList = courseStudentDTO.getStudents ();
            for (Student student : studentList) {
                System.out.println ("----->"+student);
            }
        }
    }
}
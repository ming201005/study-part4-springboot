package com.springboot.mybatis03.dao;

import com.github.pagehelper.PageInfo;
import com.springboot.mybatis03.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * 描述：Mybatis 注解版的 测试
 * @author ming
 * @version 1.0
 * @date 2019-12-24 16:46
 * @see
 */
@SpringBootTest
class StudentDaoTest {

    @Autowired
    StudentDao studentDao;

    //=================查询
    /**
     * 测试查询所有的学生
     */
    @Test
    void getAllStudent(){
        List<Student> list =  studentDao.getAllStudent ();
        //打印输出
        list.forEach (System.out::println);
    }

    /**
     * 查询一个学生
     */
    @Test
    void getOneStudent(){
        Student student =  studentDao.getStudentById (7);
        System.out.println (student);
    }


    /**
     * 多条件查询，且返回部分字段
     */
    @Test
    void getStudentByQuery() {
        String name = null;
        Integer a1 = 18;
        Integer a2 = 28;
        //查询
        List<StudentVO> list = studentDao.getStudentByQuery(name, a1, a2);
        //打印
        list.forEach (System.out::println);
    }

    //=====================新增
    /**
     * 新增
     */
    @Test
    void add(){
        Student student = new Student (null,"张三",20,'男',"河北省",3);
        int rs =  studentDao.add (student);
        //打印输出
        System.out.println ("rs ="+rs);
        System.out.println ("student id = "+ student.getId ());
    }

    /**
     * 批量新增
     */
    @Test
    void batchAdd(){
        Set<Student> students = new HashSet<> ();
        students.add (new Student (null,"丽丽11",19,'女',"广西",3));
        students.add (new Student (null,"李娜22",21,'女',"广东",4));
        students.add (new Student (null,"李超33",23,'男',"重庆",4));
        //批量新增数据
        int rs =  studentDao.batchAdd (students);
        //打印输出
        System.out.println ("rs ="+rs);
    }

    //==================修改
    //只需要修改名字、年龄、性别
    @Test
    void edit() {
        Student student = new Student (14,"孙小美",18,'密',"内蒙古",2);
        int rs = studentDao.edit (student);
        //打印输出
        System.out.println ("rs ="+rs);
    }


    //==================删除
    //根据id删除数据
    @Test
    void delById(){
        int rs = studentDao.delById (16);
        //打印输出
        System.out.println ("rs ="+rs);
    }

    //批量删除数据
    @Test
    void delByIds(){
        int rs = studentDao.delByIds (20,21,22);
        //打印输出
        System.out.println ("rs ="+rs);
    }

    //================更多查询
    //分页查询
    @Test
    void selectPage(){
        //搜索关键字
        String name = "小";
        //当前页
        int current = 1;
        //每页显示条数
        int pageSize= 3;
        List<Student> list =  studentDao.selectPage(name, current,pageSize);

        //转换结果
        PageInfo<Student> pageInfo = PageInfo.of (list);
        System.out.println ("总记录数=" + pageInfo.getTotal ());
        System.out.println ("每页显示=" + pageInfo.getPageSize ());
        System.out.println ("总页数=" + pageInfo.getPages ());
        System.out.println ("当前页=" + pageInfo.getPageNum ());
        System.out.println ("当前页数据=");
        list.forEach (System.out::println);
    }

    //1：1查询 学生-年级
    @Test
    void getRalation01(){
       List<StudentDTO> list = studentDao.getRalation01 ();
       //打印查询结果
       list.forEach (System.out::println);
    }

    //1：n查询 年级-学生
    @Test
    void  getRalation02(){
        List<GradeDTO> list = studentDao.getRalation02 ();
        //打印查询结果
        list.forEach (System.out::println);
    }

    //n:m查询 课程维度查询 课程->学生
    @Test
    void getCourseList(){
        List<CourseDTO> list = studentDao.getCourseAndStudents ("软件工程");
        list.forEach (System.out::println);
    }

    //n:m查询 学生维度查询 学生->课程
    @Test
    void  getStudentsAndCourse() {

        //查询编号等于 1的学生以及他所选修的课程。
        Integer  studentId = 1;

        List<StudentDTO> list = studentDao.getStudentsAndCourse (studentId);
        for (StudentDTO student: list) {
            System.out.println (student);
        }
    }

    //-----------动态SQL Provider
    //普通查询
    @Test
    void getStudentsAndCourseOfProvider() {
        List<StudentDTO> list = studentDao.getStudentsAndCourseOfProvider (3);
        for (StudentDTO student: list) {
            System.out.println (student);
        }
    }

    // 单个数据插入
    @Test
    void addOfSQLProvider() {
        Student student =  new Student (null,"刘楠楠GGG",19,'女',"广西",3);
        studentDao.addOfSQLProvider (student);
    }

    //批量插入
    @Test
    void batchAddOfSQLProvider(){
        Student[] students = new Student[3];
        students[0] = new Student (null,"刘楠楠A",19,'女',"广西",3);
        students[1] = new Student (null,"刘楠楠B",21,'女',"广东",4);
        students[2] = new Student (null,"刘楠楠C",23,'男',"重庆",4);
        //批量新增数据
        studentDao.batchAddOfSQLProvider (students);
    }
}
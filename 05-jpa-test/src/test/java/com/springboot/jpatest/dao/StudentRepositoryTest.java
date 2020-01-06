package com.springboot.jpatest.dao;

import com.springboot.jpatest.entity.Student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * 描述：测试
 *
 * @author ming
 * @version 1.0
 * @date 2020-01-05 13:58
 * @see
 */
@RunWith (SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository repository;


    /**
     * 基于JPA查询数据库数据
     */
    @Test
    public void select() {
        List<Student> list = repository.findAll ();
        list.forEach (System.out::println);
    }

    /**
     * 根据ID查询一条记录
     */
    @Test
    public void selectById() {
        Optional<Student> optionalStudent = repository.findById (6);
        System.out.println (optionalStudent.get ());
    }


    /**
     * 新增
     */
    @Test
    public void add() {
        Student student = new Student (0, "TEST-李", "男", 19);
        repository.save (student);
        System.out.println (student);
    }

    /**
     * 修改
     */
    @Test
    public void edit() {
        Student student = new Student ();
        student.setId (6);
        student.setName ("李玲");
        repository.saveAndFlush (student);

        System.out.println (student);
    }


    /**
     * 删除
     */
    @Test
    public void delete() {
        repository.deleteById (2);
    }
}

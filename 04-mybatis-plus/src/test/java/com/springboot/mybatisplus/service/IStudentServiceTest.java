package com.springboot.mybatisplus.service;

import com.springboot.mybatisplus.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import java.util.Set;


/**
 * 描述：测试IStudentService接口
 * @author ming
 * @version 1.0
 * @date 2020-01-03 09:37
 * @see
 */
@SpringBootTest
class IStudentServiceTest {

    @Autowired
    IStudentService iStudentService;

    /**
     * 测试查询
     */
    @Test
    void select() {
        iStudentService.list ();
    }


    /**
     * 测试批量插入数据
     */
    @Test
    void  batchAdd() {
        Set<Student> students = new HashSet<> ();
        students.add (new Student (null, "小燕子", "女", 18, "河南", 1));
        students.add (new Student (null, "腾格尔", "男", 22, "河南", 1));
        students.add (new Student (null, "香妃", "女", 19, "河南", 1));
        students.add (new Student (null, "朱哥哥", "男", 23, "河南", 1));
        students.add (new Student (null, "刘再先", "男", 25, "河南", 1));
        //调用批量插入数据，条数默认最大是1000。如果量太大，可以给一个设置大小的参数
        //建议不超过2000条，如果大批量的数据，可以再分割成多份（多批量）进行数据的插入
        boolean rs = iStudentService.saveBatch (students);
        System.out.println ("批量插入数据情况=》"+rs);
    }


    /**
     * 批量修改数据
     */
    @Test
    void batchUpdate() {
        Set<Student> students = new HashSet<> ();
        //把id=33、34、35的三条记录修改一下。
        //部分字段不修改则保留null。
        students.add (new Student (33, null, "女", 30, null, null));
        students.add (new Student (34, null, "女", 28, "湖南", 3));
        students.add (new Student (35, null, "女", null, "贵州", 4));
        //调用updateBatchById，通过id修改数据
        iStudentService.updateBatchById (students);
    }

}
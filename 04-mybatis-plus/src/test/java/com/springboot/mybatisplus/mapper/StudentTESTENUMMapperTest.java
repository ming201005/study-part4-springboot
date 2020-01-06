package com.springboot.mybatisplus.mapper;

import com.springboot.mybatisplus.entity.StudentTESTENUM;
import com.springboot.mybatisplus.enums.GradeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


/**
 * 描述：测试枚举
 *
 * @author ming
 * @version 1.0
 * @date 2020-01-03 11:44
 * @see
 */
@SpringBootTest
class StudentTESTENUMMapperTest {

    @Autowired
    StudentTESTENUMMapper mapper;


    /**
     * 查询
     */
    @Test
    void select() {
        List<StudentTESTENUM> list = mapper.selectList (null);
        list.forEach (System.out::println);
    }


    /**
     * 测试插入
     */
    @Test
    void insert() {
        StudentTESTENUM student = new StudentTESTENUM ();
        student.setName ("李逵");
        student.setSex ("男");
        //取值来自枚举中
        student.setGradeEnum (GradeEnum.GRADE_THREE);
        int rs =  mapper.insert (student);
        System.out.println ("rs==>"+rs);
    }
}
package com.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 描述：测试AR模式的调用
 *
 * @author ming
 * @version 1.0
 * @date 2020-01-04 15:11
 * @see
 */
@SpringBootTest
class StudentARTest {

    /**
     * 新增
     */
    @Test
    void add (){
        StudentAR studentAR = new StudentAR ();
        studentAR.setName ("我是AR");
        //直接调用insert方法
        studentAR.insert ();
    }

    /**
     * 查询
     */
    @Test
    void  select() {
        LambdaQueryWrapper<StudentAR>  lambdaQueryWrapper = new LambdaQueryWrapper<> ();
        lambdaQueryWrapper
                //查询年龄大于18岁的女生
                .gt (StudentAR::getAge, 18)
                .eq (StudentAR::getSex, "女");
        //调用方法
        List<StudentAR> list = new  StudentAR ().selectList (lambdaQueryWrapper);
        list.forEach (System.out::println);
    }
}
package com.springboot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.springboot.mybatisplus.entity.Grade;
import com.springboot.mybatisplus.entity.Student;
import com.springboot.mybatisplus.entity.StudentDTO;
import com.springboot.mybatisplus.entity.StudentVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 描述：学生DAO层接口
 * 直接继承BaseMapper，自带了通用的CURD方法。
 * @author ming
 * @version 1.0
 * @date 2019-12-29 16:06
 * @see
 */

public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 自定义查询方法，请注意注解说明
     * @param wrapper
     * @return
     */
    //定义查询SQL语句,${ew.customSqlSegment}是固定写法
    @Select("select * from student ${ew.customSqlSegment}")
    //增加结果集的映射，如果不加映射可以让select的查询字段和StudentVO属性名称一致，否则无法自动匹配映射
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "student_name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age")
    })
    //@Param(Constants.WRAPPER) Wrapper wrapper是固定写法。
    public List<StudentVO> getStudentByGradeId(@Param(Constants.WRAPPER) Wrapper wrapper);


    //----------------------------------------1:1关联查询 start

    /**
     * 1：1关联查询：一个学生在某个年级下
     * @param wrapper
     * @return
     */
    //定义查询SQL语句,${ew.customSqlSegment}是固定写法
    @Select("select * from student ${ew.customSqlSegment}")
    @Results({
            @Result(column = "id", property = "id",id = true),
            @Result(column = "student_name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age"),
            @Result(column = "addr", property = "addr"),
            @Result(column = "grade_id", property = "gradeId"),
            @Result(column = "grade_id", property = "grade",
                one = @One(select = "getGrade",fetchType = FetchType.EAGER)
            )
    })
    public List<StudentDTO> getStudentAndGrade(@Param(Constants.WRAPPER) Wrapper wrapper);


    /**
     * 通过年级id查询年级，查询出来是一条记录
     * @param id
     * @return
     */
    @Select ("select * from grade where id=#{id}")
    public Grade getGrade(@Param ("id") Integer id);

    //----------------------------------------1:1关联查询 end

    //----------------------------------------1:N关联查询 start

    /**
     * 1:N关联查询：一个年级下有n个学生
     * @param wrapper
     * @return
     */
    //定义查询SQL语句,${ew.customSqlSegment}是固定写法
    @Select ("select * from grade ${ew.customSqlSegment}")
    @Results({
            @Result(column = "id", property = "id",id = true),
            @Result(column = "id", property = "studentDTOList",
                    many = @Many(select = "getStudentDTOList", fetchType = FetchType.LAZY)
            )
    })
    public List<Grade> getGradeAndStudent(@Param(Constants.WRAPPER) Wrapper wrapper);

    /**
     * 通过年级ID查询学生，查询出来是多条记录
     * @param gradeId
     * @return
     */
    @Select ("select * from student where grade_id=#{gradeId}")
    @Results({
            @Result(column = "id", property = "id",id = true),
            @Result(column = "student_name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age"),
            @Result(column = "addr", property = "addr"),
            @Result(column = "grade_id", property = "gradeId"),
    })
    public List<StudentDTO> getStudentDTOList(@Param ("gradeId") Integer gradeId);

    //----------------------------------------1:N关联查询 end
}

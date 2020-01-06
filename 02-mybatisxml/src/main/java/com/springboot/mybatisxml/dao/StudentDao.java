package com.springboot.mybatisxml.dao;
import com.github.pagehelper.PageInfo;
import com.springboot.mybatisxml.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 描述：学生接口层
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-19 17:58
 * @see
 */
@Mapper
public interface StudentDao {

      //====================================================最基本的方法
      /**
       * 查询所有数据
       */
      List<Student> allStudents();

      /**
       * 新增数据，支持单条新增操作
       * @param student
       */
      void add(Student student);

      /**
       * 编辑数据，根据id编辑，支持单条编辑操作
       * @param student
       */
      void edit(Student student);

      /**
       * 根据id编辑数据，支持单条删除操作
       * @param id
       */
      void delete(Integer id);

      //====================================================更符合需求的方法

      /**
       * 插入返回ID
       * @param student
       * @return
       */
      Integer addReturnId(Student student);

      //插入返回ID方法2（请注意xml中的配置）
      Integer addReturnId02(Student student);

      //更新，如果字段为空就不更新
      Integer editFields(Student student);

      /**
       * 多条件查询
       * @param studentName 模糊匹配名称
       * @param sex 性别
       * @param age01 年龄范围开始
       * @param age02 年龄范围结束
       * @return
       */
      List<Map<String,Object>> getStudentsByQuery(
              @Param ("studentName") String studentName,
              @Param ("sex") char sex,
              @Param ("age01") Integer age01,
              @Param ("age02") Integer age02);

      /**
       * 批量删除数据 ，用可变参数来传值
       * @param ids 可变参数，即支持多个id传值。
       */
      int deleteByIds(@Param("ids") Integer ...ids);

      /**
       * 批量插入数据 ，用List来装
       * @param students
       * @return
       */
      int insertBatch(@Param ("students") List<Student> students);

      /**
       * 批量更新,用SET来装
       * @param students
       */
      int editBatch01(@Param ("students") List<Student> students);


      /**
       * 通过分页 查询所有数据 xml中不用管这两个参数的取值
       * @param pageNum
       * @param pageSize
       * @return
       */
      PageInfo<Student> allStudents(@Param("pageNum") int pageNum,
                                    @Param("pageSize") int pageSize);
}

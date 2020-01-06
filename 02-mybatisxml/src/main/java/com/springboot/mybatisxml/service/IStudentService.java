package com.springboot.mybatisxml.service;

import com.github.pagehelper.PageInfo;
import com.springboot.mybatisxml.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 描述：学生服务层——接口
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-19 18:01
 * @see
 */

public interface IStudentService {

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

    //插入返回ID方法2
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
    List<Map<String,Object>> getStudentsByQuery(String studentName,
                                                char sex,
                                                Integer age01,
                                                Integer age02) throws Exception;


    /**
     * 批量删除数据
     * @param ids 可变参数，即支持多个id传值。
     */
    int deleteByIds(Integer ...ids);

    /**
     * 批量插入数据
     * @param students
     * @return
     */
    int insertBatch(List<Student> students);


    /**
     * 批量更新,用SET来装
     * @param students
     */
    int editBatch01(List<Student> students);


    /**
     * 分页查询
     * @param currentNumber 当前页
     * @param pageSize 每页显示条数
     * @return
     */
    PageInfo getAllOffPage(int currentNumber,int pageSize);

    /**
     * 通过分页 查询所有数据 xml中不用管这两个参数的取值
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Student> allStudents(int pageNum,  int pageSize);
}

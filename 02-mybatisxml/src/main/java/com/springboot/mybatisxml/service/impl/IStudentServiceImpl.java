package com.springboot.mybatisxml.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mybatisxml.dao.StudentDao;
import com.springboot.mybatisxml.model.Student;
import com.springboot.mybatisxml.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述：学生服务层实现
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-19 18:03
 * @see
 */
@Service
public class IStudentServiceImpl implements IStudentService{
    @Autowired
    StudentDao studentDao;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Student> allStudents(){
        return studentDao.allStudents ();
    }

    /**
     * 新增数据，支持单条新增操作
     * @param student
     */
    @Override
    public void add(Student student){
        studentDao.add (student);
    }

    /**
     * 编辑数据，根据id编辑，支持单条编辑操作
     * @param student
     */
    @Override
    public void edit(Student student){

        studentDao.edit (student);
    }

    /**
     * 根据id编辑数据，支持单条删除操作
     * @param id
     */
    @Override
    public  void delete(Integer id){
        studentDao.delete (id);
    }

    //====================================================更符合需求的方法
    /**
     * 插入返回ID
     * @param student
     * @return
     */
    @Override
    public Integer addReturnId(Student student){
        return studentDao.addReturnId (student);
    }

    //插入返回ID
    @Override
    public Integer addReturnId02(Student student){
        return studentDao.addReturnId02 (student);
    }

    //字段不为空才更新
    @Override
    public Integer editFields(Student student) {
        return studentDao.editFields (student);
    }

    //多条件查询
    @Override
    public List<Map<String,Object>> getStudentsByQuery (
            String studentName,
            char sex,
            Integer age01,
            Integer age02) throws Exception {
        //一些逻辑的处理
        //如果两个都有值，那么就需要满足
        //age01 < age02 的条件
        if(age01!=null && age02!=null) {
            if (age01 > age02)
                throw new Exception ("age02需要大于age01。");
        }
        //调用getStudentsByQuery
        return studentDao.getStudentsByQuery (studentName, sex, age01, age02);
    }

    //批量删除数据
    @Override
    public int deleteByIds(Integer... ids) {
        return studentDao.deleteByIds (ids);
    }

    //批量插入数据
    @Override
    public int insertBatch(List<Student> students) {
        return studentDao.insertBatch (students);
    }

    //批量更新,用SET来装
    @Override
    public int editBatch01(List<Student> students) {
        return studentDao.editBatch01 (students);
    }

    /**
     * 分页查询
     * @param currentNumber 当前页
     * @param pageSize 每页显示条数
     * @return
     */
    @Override
    public PageInfo getAllOffPage(int currentNumber, int pageSize) {
        //设置分页
        PageHelper.startPage (currentNumber, pageSize, "AGE DESC");
        //调用Mapper的一般查询方法
        List<Student> list = studentDao.allStudents ();
        return PageInfo.of (list);
    }

    /**
     * 通过分页 查询所有数据,注意和上面的getAllOffPage区别
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Student> allStudents(int pageNum,  int pageSize) {
        return  studentDao.allStudents (pageNum, pageSize);
    }
}

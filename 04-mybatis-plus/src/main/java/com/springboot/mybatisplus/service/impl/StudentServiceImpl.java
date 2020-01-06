package com.springboot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.mybatisplus.mapper.StudentMapper;
import com.springboot.mybatisplus.entity.Student;
import com.springboot.mybatisplus.service.IStudentService;
import org.springframework.stereotype.Service;

/**
 * 描述：学生服务层接口实现类
 *
 * @author ming
 * @version 1.0
 * @date 2020-01-01 12:43
 * @see
 */
@Service
public class StudentServiceImpl
        extends ServiceImpl<StudentMapper, Student>
        implements IStudentService {

}

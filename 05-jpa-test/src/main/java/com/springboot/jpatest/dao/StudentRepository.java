package com.springboot.jpatest.dao;

import com.springboot.jpatest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 描述：dao
 *
 * @author ming
 * @version 1.0
 * @date 2020-01-05 13:55
 * @see
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {

}

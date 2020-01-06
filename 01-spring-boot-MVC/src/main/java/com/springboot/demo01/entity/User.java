package com.springboot.demo01.entity;


import lombok.Data;

/**
 * 描述：用户实体类
 * 暂时还没有用到数据库
 * @author ming
 * @version 1.0
 * @date 2019-12-13 18:50
 * @see
 */
@Data
public class User {
    int id;
    String name;
    String age;
}

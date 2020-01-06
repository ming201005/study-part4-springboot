#1 study-part4-springboot介绍
study-part4-springboot是《全栈工程师修炼之路》的Part4部分。本教程是书籍+源代码+视频（未来录制）
本教室是本人原创教程，89%示例都经过本人所敲代码，引用他人示例的本人会标明引入来源。原创不容易，请支持。

#2 源码包括：
1. SpringMVC常用的注解；
2. SpringBoot整合MyBatis的XML配置；
3. SpringBoot整合MyBatis的注解配置；
4. SpringBoot整合MyBatis-Plus配置；
5. SpringBoot整合MongDB；（更新中）
6. SpringBoot整合ES；（更新中）
7. SpringBoot更多整合；
8. SpringBoot实际项目案例；

#3 数据库相关
##3.1 基本步骤：
1. 请先创建数据库；
2. 查看相关数据库源连接，和数据库不对应的请自行调整；
3. 找到test下的相关测试类，进行测试；
4. 建议找到select查询测试方法，运行看看；
5. 之后一次通过test类中的所有方法执行：新增、修改、删除、查询、分页等；


##3.1 "SpringBoot整合MyBatis的XML配置" 数据库名称：02-mybatisxml
##3.2 数据库结构：
```sql
create table if not exists course
(
  id          int auto_increment,
  course_name varchar(45)   not null,
  sort        int default 0 null,
  constraint id_UNIQUE
    unique (id)
);

alter table course
  add constraint `PRIMARY`
    primary key (id);

create table if not exists grade
(
  id         int auto_increment comment '主键'
    constraint `PRIMARY`
    primary key,
  grade_name varchar(255) null comment '年级'
)
  comment '年级信息表';

create table if not exists student
(
  id           int auto_increment comment '主键'
    constraint `PRIMARY`
    primary key,
  student_name varchar(255) not null comment '学生姓名',
  age          int          null comment '年龄',
  sex          varchar(1)   null comment '性别',
  addr         varchar(255) null comment '家庭住址',
  grade_id     int          null,
  constraint grade_id
    foreign key (grade_id) references grade (id)
)
  comment '学生信息表';

create table if not exists course_student_mid
(
  id         int auto_increment,
  course_id  int null,
  student_id int null,
  constraint id_UNIQUE
    unique (id),
  constraint course_id
    foreign key (course_id) references course (id),
  constraint student_id
    foreign key (student_id) references student (id)
);

create index course_id_idx
  on course_student_mid (course_id);

create index student_id_idx
  on course_student_mid (student_id);

alter table course_student_mid
  add constraint `PRIMARY`
    primary key (id);
```

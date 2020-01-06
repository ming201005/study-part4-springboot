package com.springboot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.mybatisplus.entity.Grade;
import com.springboot.mybatisplus.entity.Student;
import com.springboot.mybatisplus.entity.StudentDTO;
import com.springboot.mybatisplus.entity.StudentVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * 描述：测试
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-29 16:07
 * @see
 */
@SpringBootTest
class StudentMapperTest {
    @Autowired
    StudentMapper studentMapper;

    //---------------------------第1节

    /**
     * 查询所有
     */
    @Test
    void selectAll(){
       List<Student> list = studentMapper.selectList (null);
       list.forEach (System.out::println);
    }

    /**
     * 新增一条数据
     */
    @Test
    void  add(){
        Student student = new Student (0,"莫瑞雪","男",9,"重庆",1,0);
        int rs =  studentMapper.insert (student);
        //打印结果：
        System.out.println ("rs==>"+rs+"\n"+student);
    }


    /**
     * 根据id更新数据
     */
    @Test
    void updateById(){
        Student student = new Student (33,null,"女",25,"河南",3);
        int rs =  studentMapper.updateById (student);
        //打印结果：
        System.out.println ("rs==>"+rs+"\n"+student);
    }

    /**
     * 通过ID删除数据
     */
    @Test
    void deleteById() {
        int rs =   studentMapper.deleteById (33);
        //打印结果：
        System.out.println ("rs==>"+rs);
    }


    //---------------------------第2节

    /**
     * 指定查询字段
     */
    @Test
    void selectFields(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        //指定查询的字段，可以给字段设置别名
        queryWrapper.select ("id","student_name as name","age");
        //调用selectList方法
        //传递参数queryWrapper
        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * 条件查询："="
     * 相当于：where age=18
     */
    @Test
    void  selectEQ() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        //查询年龄=18岁。
        queryWrapper.eq ("age", 18);
        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * 条件查询："<>、！="
     * 相当于：where sex ！='男'
     */
    @Test
    void  selectNE() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        //排除"男"的学生 （只查询女生和保密性别的学生）
        queryWrapper.ne ("sex", "男");
        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * 1.包含关键字的查询      like
     * 2.以关键字结尾的匹配查询 likeLeft
     * 3.以关键字开头的匹配查询 likeRight
     */
    @Test
    void  selectLike() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        //1.包含关键字的查询。
        //queryWrapper.like ("addr", "北");
        //2.以关键字结尾的匹配查询
        //queryWrapper.likeLeft ("addr", "北");
        //3.以关键字开头的匹配查询
        queryWrapper.likeRight ("addr", "广");

        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * 多条件组合查询
     * 相当于SQL：
     * select * from student
     * where sex='女'
     *    and grade_id between 2 and 3
     *    and age>=18
     *    and age<=22
     *    and addr like %'广西'%
     *    and student_name '刘%'
     */
    @Test
    void selectByMoreQuery() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        queryWrapper
                .eq ("sex", "女")
                .between ("grade_id", 1, 3)
                .ge ("age", 18)
                .le ("age", 22)
                .like ("addr", "广")
                .likeRight ("student_name", "刘");
        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * OR条件拼接 -简单拼接
     */
    @Test
    void selectOR01() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        queryWrapper
                .eq ("sex", "男")
                .or ()
                .gt ("age", 18)
                .lt ("age", 22);
        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * OR条件拼接 —带括号拼接
     */
    @Test
    void selectOR02() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        queryWrapper
                .eq ("sex", "男")
                .or (qw->qw
                        .gt ("age", 18)
                        .lt ("age", 22)
                );
        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * 带and的连接
     */
    @Test
    void selectAND() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        queryWrapper
                .eq ("sex", "男")
                .and (qw->qw
                        .gt ("age", 25)
                        .lt ("age", 35)
                );
        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * 正常加括号嵌套拼接，没有or或and (默认是and连)。
     */
    @Test
    void selectNested() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        queryWrapper
                .eq ("sex", "男")
                //.or ()
                .nested (qw->qw
                        .gt ("age", 18)
                        .lt ("age", 22)
                );
        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * OR AND 多层嵌套
     */
    @Test
    void selectORAND() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        queryWrapper
                .nested (qw->qw
                        .gt ("age", 18)
                        .lt ("age", 35)
                        .eq ("addr", "广西")
                ).
                or (
                        orQW->orQW
                                .eq ("sex", "男")
                                .like ("addr", "重庆")
                                .and (andWQ->andWQ
                                        .eq ("grade_id", "4")
                                        .or ().lt ("age", 18)
                                )
                );
        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }


    /**
     * IN子查询
     */
    @Test
    void selectIN() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        queryWrapper.in ("grade_id",1,2);
        //
        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * IN子查询
     */
    @Test
    void selectINSQL() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        queryWrapper.inSql ("grade_id","select id from grade where id>2");
        //
        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * SQL拼接
     */
    @Test
    void selectApply() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        //1、无参数
        queryWrapper.apply (" id !=5 ");
        //2、有参数
        queryWrapper.apply (" id !={0} and  substr(addr,0,4)={1}",3,"重庆");

        String key = null;
        Integer num  = null;
        //3、添加执行条件
        queryWrapper.apply (
                num>0 && StringUtils.isNotEmpty (key),
                " id !={0} and  substr(addr,0,4)={1}",
                num,
                key);

        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    //---------------------------第3节

    /**
     * 查询结果排序
     */
    @Test
    void selectOrderBy(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        //单个字段排序
        queryWrapper.orderByDesc ("id");
        //多个字段排序
        queryWrapper.orderByAsc ("grade_id","age");
        //TODO

        List<Student> list = studentMapper.selectList (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }


    /**
     * 分组统计：按照性别统计学生人数
     */
    @Test
    void selectGROUPBY(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        queryWrapper
                .select ("sex","count(*) as count")
                .groupBy ("sex");
        //调用selectMaps方法
        List<Map<String,Object>> list = studentMapper.selectMaps (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }

    /**
     * 分组统计:按照性别统计学生人数，性别不公开的不统计.
     */
    @Test
    void selectGROUPBYHAVING(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        queryWrapper
                .select ("sex","count(*) as count")
                .groupBy ("sex")
                //第一个参数是合法的SQL，第二个参数是填充第一个参数的格式化参数
                //例如：把统计结果除掉性别"保密"的学生，同时只统计数量大于12的学生
                .having ("sex!={0}","密");
        //调用selectMaps方法
        List<Map<String,Object>> list = studentMapper.selectMaps (queryWrapper);
        //测试：打印结果
        list.forEach (System.out::println);
    }


    /**
     *  查询一条记录，方法selectOne的使用
     *  注意：这个方法要求查询结果集必须只有一条记录，否则报错。
     */
    @Test
    void selectOne() {
        //查询条件
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        queryWrapper.eq ("sex", "男");

        //调用selectOne
        Student student = studentMapper.selectOne (queryWrapper);
        //打印结果
        System.out.println (student);
    }

    /**
     * 根据ID查询一条数据
     * 这个方法要求查询的结果集有无数据都无所谓，不会报错。
     */
    @Test
    void selectById() {
       Student student =  studentMapper.selectById (3);
       System.out.println (student);
    }


    //---------------------------第4节

    /**
     * 分页查询
     */
    @Test
    void selectPage() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        //查询条件,跟之前没什么变化
        queryWrapper
                .eq ("grade_id", 3)
                .orderByDesc ("id");
        //设置当前页
        long current = 1;
        //设置每页显示条数
        long pageSize = 5;
        //创建分页插件的实例，并传当前页、每页显示页数两个参数
        IPage<Student> page = new Page<> (current, pageSize);
        //调用分页方法selectPage，并传递page和查询条件queryWrapper
        IPage<Student> studentIPage = studentMapper.selectPage (page, queryWrapper);
        //-------------------------打印结果
        //总条数
        System.out.println ("总条数="+studentIPage.getTotal ());
        //当前页
        System.out.println ("当前页="+studentIPage.getCurrent ());
        //每页显示条数
        System.out.println ("每页显示条数="+studentIPage.getSize ());
        //一共有多少页
        System.out.println ("共有页数="+studentIPage.getPages ());
        //当前页的数据
        System.out.println ("-------------------当前页数据如下：");
        List<Student> list = studentIPage.getRecords ();
        list.forEach (System.out::println);
    }


    /**
     * 自定义查询
     */
    @Test
    void getStudentByGradeId(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        //查询大三的学生，并按年龄从小到大排序
        queryWrapper.eq ("grade_id", 3).orderByAsc ("age");
        //调用StudentMapper接口中自定义的方法getStudentByGradeId
        //返回结果为List,泛型变成了StudentVO。
        List<StudentVO> list = studentMapper.getStudentByGradeId (queryWrapper);
        //输出结果
        list.forEach (System.out::println);
    }

    /**
     * 1:1 关联查询：学生+年级查询
     */
    @Test
    void getStudentAndGrade() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();

        List<StudentDTO> list = studentMapper.getStudentAndGrade (queryWrapper);
        //输出结果
        list.forEach (System.out::println);
    }

    /**
     * 1:n 关联查询：年级查询+学生
     */
    @Test
    void getGradeAndStudent() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        //查询三年级（大三）
        queryWrapper.eq ("id", "3");
        List<Grade> list = studentMapper.getGradeAndStudent (queryWrapper);
        //输出结果
        for (Grade grade : list) {
            System.out.println (grade.display ());
            //取得某年级下的所有学生
            List<StudentDTO> studentDTOList = grade.getStudentDTOList ();
            //输出
            System.out.println ("--------->"+grade.getGradeName ()+"的学生有：");
            studentDTOList.forEach (item->{
               System.out.println (item.display ());
            });
        }
    }

    //---------------------------第5节

    /**
     * 带条件更新
     */
    @Test
    void updateByQuery() {

        Student student = new Student ();
        student.setAge (28);
        student.setSex ("男");
        //条件
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<> ();
        updateWrapper
                .eq ("id", 3)
                //.set ("sex","女")
                .set ("addr", "美国洛杉矶");
        //更新
        int rs = studentMapper.update (student,updateWrapper);
        System.out.println ("执行结果==》"+rs);
    }

    /**
     * 带条件删除
     */
    @Test
    void delete() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<> ();
        //删除ID大于30的学生
        queryWrapper.gt ("id", 35);
        //删除
        int rs =  studentMapper.delete (queryWrapper);
        System.out.println ("执行结果==》"+rs);
    }

    //------------------批量

    @Test
    void batchAdd() {
        //studentMapper.
    }


}
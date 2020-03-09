package com.springboot.mybatisxml;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mybatisxml.model.Student;
import com.springboot.mybatisxml.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * 测试类
 */
@SpringBootTest
class MybatisxmlApplicationTests {

    //调用的是接口
    @Autowired
    IStudentService iStudentService;

    //====================================================最基本的方法

    /**
     * 测试查询全部数据
     */
    @Test
    void getall() {
        List<Student> list = iStudentService.allStudents ();
        list.forEach (System.out::println);
    }

    /**
     * 新增数据
     */
    @Test
    void add() {
        Student student = new Student ();
        //不设置ID
        student.setStudentName ("岳飞");
        student.setSex ('男');
        student.setAge (28);
        student.setAddr ("河北");
        student.setGradeId (2);
        //执行插入方法
        iStudentService.add (student);

        System.out.println (student.toString ());
    }

    /**
     * 修改数据
     */
    @Test
    void edit() {
        Student student = new Student ();
        student.setId (1);
        student.setStudentName ("小乔");
        student.setSex ('女');
        student.setAge (18);
        student.setAddr ("安徽");
        student.setGradeId (2);
        //执行编辑方法
        iStudentService.edit (student);
    }

    /**
     * 删除数据
     */
    @Test
    void delete() {
        Integer id = 2;
        //执行编辑方法
        iStudentService.delete (id);
    }


    //====================================================更符合需求的方法
    //插入返回ID方法1测试
    @Test
    void addReturnId() {
        Student student = new Student ();
        //不设置ID
        student.setStudentName ("关于");
        student.setSex ('男');
        student.setAge (38);
        student.setAddr ("山西");
        student.setGradeId (4);
        //执行插入方法addReturnId
        Integer rs = iStudentService.addReturnId (student);

        System.out.println ("rs=" + rs);
        System.out.println (student.toString ());

    }

    //插入返回ID方法2测试
    @Test
    void addReturnId02() {
        Student student = new Student ();
        //不设置ID
        student.setStudentName ("赵子龙");
        student.setSex ('男');
        student.setAge (28);
        student.setAddr ("长白山赵子龙也。。。");
        student.setGradeId (3);
        //执行插入方法addReturnId
        Integer rs = iStudentService.addReturnId02 (student);

        System.out.println ("rs=" + rs);
        System.out.println (student.toString ());

    }

    /**
     * 修改数据部分数据
     * 直接利用edit执行，部分数据是null，会报错的。
     * 这时候就发现mybatis的配置慢慢变复杂了。。。
     * 解决方案：
     * 方案1、先查询、在更新；
     * 方案2、配置xml，判断语句：
     * <if test="StudentName != null">
     * student_name=#{StudentName}
     * </if>
     * 只要有可能的是null地方，都需要配置。
     */
    @Test
    void edit02() {
        // 只修改年龄，其他不修改。
        // 此时运行会报错。解决方案见注解。
        Student student = new Student ();
        student.setId (4);
        //student.setStudentName ("张飞");
        //student.setSex ('男');
        student.setAge (21);
        //student.setAddr ("河北");
        //student.setGradeId (2);
        //执行编辑方法
        iStudentService.edit (student);
    }

    //更新部分字段方法测试
    @Test
    void editFields() {
        // 只修改年龄，其他不修改。
        Student student = new Student ();
        student.setId (4);
        student.setAge (15);
        //执行编辑方法editFields
        Integer rs = iStudentService.editFields (student);
        System.out.println ("rs=" + rs);
    }

    //多条件查询
    @Test
    void getStudentsByQuery() throws Exception {
        String studentName = "飞";
        char sex = '\u0000';
        Integer age01 = 18;
        Integer age02 = 28;
        List<Map<String, Object>> list = iStudentService.getStudentsByQuery (
                studentName, sex, age01, age02);
        //打印测试结果
        list.forEach (System.out::println);
    }

    /**
     * 批量删除数据
     */
    @Test
    void deleteByIds() {
        //执行编辑方法
        int rs = iStudentService.deleteByIds (9, 10);
        System.out.println ("rs=" + rs);
    }

    /**
     * 批量插入数据
     */
    @Test
    void insertBatch() {
        List<Student> students = new ArrayList<> ();
        students.add (new Student (null, "张三", 19, '男', "广西", 2));
        students.add (new Student (null, "李四", 21, '男', "广东", 1));
        students.add (new Student (null, "王五", 23, '男', "合肥", 3));
        students.add (new Student (null, "小美", 25, '女', "黑龙江", 4));
        students.add (new Student (null, "小莲", 18, '女', "内蒙古", 3));
        int rs = iStudentService.insertBatch (students);
        System.out.println ("rs=" + rs);
    }


    /**
     * 批量更新数据
     */
    @Test
    void editBatch01() {
        List<Student> students = new ArrayList<> ();
        students.add (new Student (11, "张三111", 32, '男', "广西", 2));
        students.add (new Student (12, "小芳", 15, '女', "广东", 1));
        students.add (new Student (13, "王五55", 29, '男', "合肥", 3));
        students.add (new Student (14, "小美22", 23, '女', "黑龙江", 4));
        students.add (new Student (15, "小莲44", 19, '女', "内蒙古", 3));
        int rs = iStudentService.editBatch01 (students);
        System.out.println ("rs=" + rs);
    }

    /**
     * 分页查询，调用方式1 PageHelper.startPage
     */
    @Test
    void pageSelect01() {

        //设置分页
        PageHelper.startPage (2, 5, "id desc");
        //调用DAO接口定义的方法，注意：完全不会影响之前的方法，太棒了！
        List<Student> list = iStudentService.allStudents ();
        //转换结果
        PageInfo page = PageInfo.of (list);
        System.out.println ("总记录数=" + page.getTotal ());
        System.out.println ("每页显示=" + page.getPageSize ());
        System.out.println ("总页数=" + page.getPages ());
        System.out.println ("当前页=" + page.getPageNum ());
        System.out.println ("当前页数据=");
        list.forEach (System.out::println);
    }

    /**
     * 分页查询，调用方式2 PageHelper.offsetPage
     */
    @Test
    void pageSelect02() {
        try {
            //设置分页，可以设置不执行count查询。
            //例如：移动端触底滚屏、网页端触底加载，就不需要查询总记录数
            PageHelper.offsetPage (2, 5, false);
            //调用DAO接口定义的方法,只要是查询方法都可以分页。
            List<Map<String, Object>> list = iStudentService
                    .getStudentsByQuery ("", '\u0000', 15, 30);
            //转换结果
            PageInfo page = PageInfo.of (list);
            //System.out.println ("总记录数=" + page.getTotal ());
            System.out.println ("每页显示=" + page.getPageSize ());
            System.out.println ("总页数=" + page.getPages ());
            System.out.println ("当前页=" + page.getPageNum ());
            System.out.println ("当前页数据=");
            list.forEach (System.out::println);
        } catch (Exception e) {
            System.out.println (e.getMessage ());
        }
    }

    /**
     * 分页查询 调用方式3 lambda表达式
     */
    @Test
    void pageSelect03() {

        PageInfo<List<Map<String, Object>>> page =
                PageHelper.startPage (1, 5, " ID DESC")
                        .doSelectPageInfo (() -> {
                            try {
                                //这里是doSelectPageInfo方法的接口参数，支持lambda表达式写法。
                                iStudentService.getStudentsByQuery ("", '\u0000', 15, 30);
                            } catch (Exception e) {
                                System.out.println (e.getMessage ());
                            }
                        });

        System.out.println ("总记录数=" + page.getTotal ());
        System.out.println ("每页显示=" + page.getPageSize ());
        System.out.println ("总页数=" + page.getPages ());
        System.out.println ("当前页=" + page.getPageNum ());
        System.out.println ("当前页数据=");
        List list = page.getList ();
        list.forEach (System.out::println);
    }


    /**
     * 分页查询 用service封装之后的分页方法
     */
    @Test
    void pageSelect04() {
        //这里是service封装之后的分页方法
        PageInfo page = iStudentService.getAllOffPage (1,3);
        //输出结果
        System.out.println ("总记录数=" + page.getTotal ());
        System.out.println ("每页显示=" + page.getPageSize ());
        System.out.println ("总页数=" + page.getPages ());
        System.out.println ("当前页=" + page.getPageNum ());
        System.out.println ("当前页数据=");
        List list = page.getList ();
        list.forEach (System.out::println);
    }

    /**
     * 分页查询 在Mapper接口上传参数
     */
    @Test
    void pageSelect05() {
        //这里是service封装之后的分页方法
        PageInfo page = iStudentService.allStudents (2, 3);
        //输出结果
        System.out.println ("总记录数=" + page.getTotal ());
        System.out.println ("每页显示=" + page.getPageSize ());
        System.out.println ("总页数=" + page.getPages ());
        System.out.println ("当前页=" + page.getPageNum ());
        System.out.println ("当前页数据=");
        List list = page.getList ();
        list.forEach (System.out::println);
    }

}

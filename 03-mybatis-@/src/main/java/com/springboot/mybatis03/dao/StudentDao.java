package com.springboot.mybatis03.dao;

import com.springboot.mybatis03.model.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Set;

/**
 * 描述：学生接口
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-24 16:44
 * @see
 */
@Mapper
public interface StudentDao {

    //1、查询==============================
    /**
     * 查询所有
     * @return
     */
    @Select ("select * from student")
    List<Student> getAllStudent();

    /**
     * 查询一个学生
     * @param id
     * @return
     */
    @Select ("select * from student where id=#{id}")
    Student getStudentById(@Param ("id") Integer id);

    /**
     * 多条件查询，且返回部分字段
     * 多条件情况下，如果为空就不拼接SQL语句
     * 用到<script></script>脚本，其语法和XML中是一样的。
     * @param nameKey 搜索姓名关键字，模糊匹配
     * @param age01   搜索年龄段开始
     * @param age02   搜搜年龄段结束
     * @return
     */
    @Select ({"<script>",
             " select id,student_name as name,sex, age from student",
             "<where>",
             " <if test='nameKey!=null'> student_name like \"%\"#{nameKey}\"%\" </if>",
             " <if test='age02>age01 and age01>0'> and age between #{age01} and #{age02} </if>",
             "</where>",
            "</script>"})
    List<StudentVO> getStudentByQuery(
            @Param ("nameKey") String nameKey,
            @Param ("age01") Integer age01,
            @Param ("age02") Integer age02);

    //2、新增==============================
    /**
     * 新增一条数据，并取得ID值
     * @param student
     * @return
     */
    @Insert ("insert into student" +
            " (student_name,sex,age,addr,grade_id) " +
            " values(#{studentName},#{sex},#{age},#{addr},#{gradeId})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int add(Student student);

    /**
     * 批量的插入数据
     * 批量更新需要拼接SQL语句，格式为：
     * insert into tableName (field1,field2, ...)
     * values (val1.1, val2.2,...),
     *        (val1.2, val2.2,...),
     *        (val1.3, val2.3,...)
     * values 之后的是需要循环拼接。
     * @param students
     * @return
     */
    @Insert ({"<script>",
            "insert  into student(student_name, age, sex, addr, grade_id) ",
            "values",
            "<foreach collection='students' item='item' separator=','>",
            " (#{item.studentName}, #{item.age}, #{item.sex}, #{item.addr}, #{item.gradeId})",
            "</foreach>",
            "</script>"})
    int batchAdd(@Param ("students") Set<Student> students);


    //3、修改==============================
    /**
     修改
     简单的更新就不演示了，传递参数和@Insert一样的。
     以下说一下在实际的业务中经常需要处理当修改数据时
     前端只传来部分的数据，确保没有数据的不更新，需要
     使用动态语句控制
     */
    @Update ({"<script>",
            "update student ",
            " <set>",
            "   <if test='studentName !=null'> student_name = #{studentName} ,</if>",
            "   <if test='sex !=null'> sex = #{sex} ,</if>",
            "   <if test='age !=null and age>0'> age = #{age} ,</if>",
            "   <if test='addr !=null'> addr = #{addr} ,</if>",
            "   <if test='gradeId !=null'> grade_id = #{gradeId}</if>",
            " </set>",
            "where id = #{id}",
            "</script>"})
    int edit(Student student);

    //4、删除==============================

    /**
     * 单个数据删除
     * @param id
     * @return
     */
    @Delete ("delete from student where id=#{id}")
    int delById(@Param ("id") Integer id);


    /**
     * 通过id删除，多个id
     * 由于是多个ID，同样需要拼接SQL语句
     * @param ids
     * @return
     */
    @Delete ({"<script>",
              " delete from student where id in (",
             "<foreach collection='ids' item='id' separator=','>",
             "#{id}",
             "</foreach>",
              ")",
              "</script>"})
    int delByIds(@Param ("ids") Integer ...ids);


    //5、更多查询==============================

    /**
     * 分页查询
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Select ("select * from student where student_name like \"%\"#{name}\"%\" ")
    List<Student> selectPage(@Param ("name") String name,
                                 @Param ("pageNum") int pageNum,
                                 @Param ("pageSize") int pageSize);


     //=======================================1：1关联查询 start
    //学生、年级 1：1
    /**
     * 1：1关联查询
     * 本次查询的示例是：学生、年级
     * @return
     */
    @Select ("select * from student")
    @Results({
            // 不映射也是可以的,如果查询复杂，且设置了别名，最好必须映射。
            // 否则会发生意外的映射错误，找不到对应的关系
            /*
            @Result(id = true,column = "id", property = "id"),
            @Result(column = "student_name", property = "studentName"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "age", property = "age"),
            @Result(column = "addr", property = "addr"),
            */
            //要关联的字段必须映射
            @Result(column = "grade_id", property = "gradeId"),
            //这里设置关联关系
            @Result(column = "grade_id", property = "grade",
                    one = @One(select = "getGrade",fetchType = FetchType.EAGER)
            )
    })
    List<StudentDTO> getRalation01();

    //为getRalation01方法 关联的查询
    @Select ("select * from  grade where id=#{id}")
    Grade getGrade(@Param ("id") Integer id);

    //=======================================1：1关联查询 end



    //=======================================1：n关联查询 start
    //年级、学生课程 1:n
    /**
     * 1对多关系查询，即：1个年级有N个学生
     * @return 返回年级+n个学生的集合
     */
    @Select ("select * from grade ")
    @Results({
            //要关联的字段一定要映射
            @Result(id = true,column = "id",property = "id"),
            //以下grade_name可以不用映射
            //@Result(column = "grade_name",property = "gradeName"),
            @Result(column = "id",property = "students",
                many = @Many(select = "getStudentByGradeId",fetchType = FetchType.EAGER)
            )
    })
    List<GradeDTO> getRalation02();

    //为getRalation02方法关联查询多个学生准备的方法
    @Select ("select * from student where grade_id=#{gradeId}")
    List<Student> getStudentByGradeId(@Param ("gradeId") Integer gradeId);

    //=======================================1：n关联查询 end



    //=======================================n：m关联查询 start
    //学生、选修课程 n:m

    //1、从课程维度查询
    @Select ("select * from  course"
             +" where course_name =#{name}")
    //映射
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "id",property = "studentsList",
                many = @Many(select = "getStudentListByCourseId" ,fetchType = FetchType.EAGER)
            )
    })
    List<CourseDTO> getCourseAndStudents(@Param ("name") String name);

    /**
     * 为 getCourseList准备的关联查询
     * @param courseId
     * @return
     */
    @Select ("select * from  student a,course_student_mid b,grade c "
            +" where a.id = b.student_id "
            +" and a.grade_id = c.id "
            +" and b.course_id = #{courseId}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "grade_id", property = "gradeId"),
            @Result(column = "grade_id", property = "grade",
                    one = @One(select = "getGrade", fetchType = FetchType.EAGER)
            )
    })
    List<StudentDTO> getStudentListByCourseId(@Param ("courseId") Integer courseId);


    //-------------------------------------------------
    //2、从学生维度查询
    /**
     * 从学生维度查询
     * @param id
     * @return
     */
    @Select ("select a.*,b.id as grade_id,b.grade_name "
            +" from student a, grade b  "
            +"where a.grade_id = b.id "
            +" and a.id=#{id}")
    @Results(id = "StudentDTOMap",
            value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "grade_id", property = "gradeId"),
            //学生和年级1：1的映射
            @Result(column = "grade_id", property = "grade",
                    one = @One(select = "getGrade",fetchType = FetchType.EAGER)
            ),
            //学生和课程，1：n的映射
            @Result(column = "id" ,property = "courses",
                    many = @Many(select = "getCourseByStudentId",fetchType = FetchType.EAGER)
            )
    })

    List<StudentDTO> getStudentsAndCourse(@Param ("id") Integer id);

    /**
     * 根据学生查询课程
     * @param id
     * @return
     */
    @Select ("select * from course a,course_student_mid b "
             +" where a.id=b.course_id and b.student_id =#{id}")
    List<CourseDTO> getCourseByStudentId(@Param ("id") Integer id);
    //=======================================n：m关联查询 end



    //=======================================动态SQL Provider

    /**
     * @SelectProvider
     * 普通的查询
     * 使用 @SelectProvider注解，让SQL和逻辑分离
     * @param id
     * @return
     */
    @SelectProvider (type = SQLProvider.class, method ="getStudentsAndCourseOfProvider")
    @ResultMap ("StudentDTOMap")
    List<StudentDTO> getStudentsAndCourseOfProvider(@Param ("id") Integer id);


    /**
     * 插入单条数据
     * @param student
     * @return
     */
    @InsertProvider (type = SQLProvider.class, method = "addOfSQLProvider")
    Integer addOfSQLProvider(@Param ("student") Student student);

    /**
     * 批量插入，使用@InsertProvider标签引用动态插入SQL
     * @param students
     * @return
     */
    @InsertProvider (type = SQLProvider.class, method = "batchAddOfSQLProvider")
    Integer batchAddOfSQLProvider(@Param ("students")Student ...students);
}

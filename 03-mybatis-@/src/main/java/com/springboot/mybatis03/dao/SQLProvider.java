package com.springboot.mybatis03.dao;

import com.springboot.mybatis03.model.Student;
import org.apache.ibatis.jdbc.SQL;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 描述：动态SQL语句
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-25 11:37
 * @see
 */
public class SQLProvider {

    /**
     * DAO中 getStudentsAndCourse的SQL
     * @param param 参数。
     * @return sql
     */
    public String getStudentsAndCourseOfProvider(Map param) {

        String sql =   new SQL () {
            {
                //可变参数
                SELECT ("a.*", "b.id as grade_id", "b.grade_name");
                //可变参数
                FROM ("student a", "grade b ");
                //也支持可变参数
                WHERE ("a.grade_id = b.id");
                Object id =  param.get ("id");
                //根据调解来拼接SQL语句
                if (null != id && (Integer)id>0 ) {
                   WHERE (" a.id = #{id}");
                }
            }
        }.toString ();

        System.out.println (sql);

        return sql;
    }

    /**
     * 插入单条数据
     * @param param
     * @return
     */
    public String addOfSQLProvider(Map param){
        //参数取值
        //Student student = (Student) param.get ("student");
        return new SQL (){
            {
                INSERT_INTO ("student");
                INTO_COLUMNS ("student_name","sex","age","addr","grade_id");
                //注意格式化，参数名称是student
                INTO_VALUES ("#{student.studentName}",
                             "#{student.sex}",
                             "#{student.age}",
                             "#{student.addr}",
                             "#{student.gradeId}");
            }
        }.toString ();
    }

    /**
     * 批量查询数据的SQL
     * @param param
     * @return
     */
    public String batchAddOfSQLProvider(Map param) {
        Student[] students = (Student[]) param.get ("students");
        String sqlStr = "";
        //直接字符串拼接。
        //优点：不需要学习成本，会字符串和SQL处理即可
        StringBuilder sql = new StringBuilder ();
        sql.append ("insert into student (student_name,sex,age,addr,grade_id)");
        sql.append ("values");
        for (int i=0;i<students.length;i++) {
            sql.append ("(");
            //注意格式化，参数是数组
            sql.append("#{students[").append (i).append ("].studentName},");
            sql.append("#{students[").append (i).append ("].sex},");
            sql.append("#{students[").append (i).append ("].age},");
            sql.append("#{students[").append (i).append ("].addr},");
            sql.append("#{students[").append (i).append ("].gradeId}");
            sql.append ("),");
        }
        sqlStr = sql.toString ();
        //去掉最后一个"，"
        sqlStr = sqlStr.substring (0,sqlStr.length ()-1);

        return sqlStr;
    }

    //更新、删除。。。。举一反三

}
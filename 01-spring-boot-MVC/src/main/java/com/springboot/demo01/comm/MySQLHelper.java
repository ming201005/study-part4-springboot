package com.springboot.demo01.comm;

import java.sql.*;

/**
 * 描述：手写测试mysql操作
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-12 21:58
 * @see
 */
public class MySQLHelper {

    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3309/db01";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/db01?useSSL=false&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "ming821215";

    /**
     * 测试
      * @param args
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql = "SELECT id, name, sex FROM USER ";
            ResultSet rs = stmt.executeQuery(sql);


            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id      = rs.getInt("id");
                String name = rs.getString("name");
                String sex  = rs.getString("sex");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 姓名: " + name);
                System.out.print(", 性别: " + sex);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){

            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
            System.out.println("结束");
        }

    }

}

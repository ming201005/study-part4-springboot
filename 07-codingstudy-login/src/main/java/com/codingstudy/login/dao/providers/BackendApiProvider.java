package com.codingstudy.login.dao.providers;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;


public class BackendApiProvider {


    /**
     * 根据用户名称获得API URL资源鉴权
     * @param params
     * @return
     */
    public String backendApiByusername(Map params){
        return new SQL(){
            {
                SELECT_DISTINCT("a.backend_api_url","a.backend_api_method");
                FROM("sys_backend_api_table a",
                        "sys_role_table b",
                        "sys_role_backend_api_table c",
                        "sys_user_table d",
                        "sys_role_user_table e");
                WHERE("a.backend_api_id = c.backend_api_id",
                        "a.backend_api_url <> 'none'",
                        "b.role_id = c.role_id",
                        "d.user_id = e.user_id",
                        "e.role_id = c.role_id",
                        "d.user_name = #{username}");
            }
        }.toString();
    }

    /**
     * 创建查询语句
     * @param params
     * @return
     */
    public String backendApiSelectSQL(Map params) {

        String[] roles = (String[])params.get("roles");

        StringBuilder sql = new StringBuilder ();
        sql.append ("select DISTINCT a.backend_api_url ,a.backend_api_method ");
        sql.append ("from sys_backend_api_table a, sys_role_table b, sys_role_backend_api_table c ");
        sql.append ("where a.backend_api_id = c.backend_api_id ");
        sql.append ("  and a.backend_api_url <> 'none' ");
        sql.append ("  and b.role_id = c.role_id ");
        sql.append ("  and b.role_name ");

        String inSQL = "in (";

        for (String role:roles) {
            inSQL +="'"+role+"',";
        }
        //去掉最后一个"，"
        inSQL = inSQL.substring (0,inSQL.length ()-1)+")";
        sql.append(inSQL);
        //返回
        return sql.toString();
    }
}

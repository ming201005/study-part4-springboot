package com.codingstudy.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codingstudy.login.entity.SysRoleTable;
import com.codingstudy.login.vo.SysRoleAndPermissionVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (SysRoleTable)表数据库访问层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-07 14:31:50
 */
public interface SysRoleTableDao extends BaseMapper<SysRoleTable> {

    @Select("SELECT b.role_name\n" +
            "from sys_user_table a,\n" +
            "\t sys_role_table b,\n" +
            "     sys_role_user_table c\n" +
            "where a.user_id = c.user_id\n" +
            "     and b.role_id = c.role_id\n" +
            "     and a.state = 1\n"+
            "     and a.user_name=#{userName}")
    List<String> getRolesByUserName(@Param("userName") String userName);


    @Select("SELECT \n" +
            "    t1.user_id as id, \n" +
            "    t1.user_name as name, \n" +
            "    t2.role_id \n" +
            "FROM\n" +
            "    sys_user_table t1\n" +
            "        LEFT JOIN\n" +
            "    (SELECT \n" +
            "        a.user_id, a.user_name, b.role_id, b.role_name\n" +
            "    FROM\n" +
            "        sys_user_table a\n" +
            "    JOIN (sys_role_table b\n" +
            "    JOIN sys_role_user_table c ON c.role_id = b.role_id) ON c.user_id = a.user_id\n" +
            "    WHERE\n" +
            "        b.role_id = #{roleId}) t2 ON t2.user_id = t1.user_id")
    /**
     * 根据roleId找用户以及用户是否被设置在某个角色上，用在显示在用于角色设置处
     */
    List<SysRoleAndPermissionVo> getRoleAndUserList(@Param("roleId") String roleId);


    @Select("select \n" +
            "  t1.frontend_menu_id as id,\n" +
            "  t1.frontend_menu_name as name ,\n" +
            "  t1.pid as pid,\n" +
            "  t2.role_id as role_id\n" +
            "from sys_frontend_menu_table t1 \n" +
            "left join\n" +
            "(\n" +
            "   select \n" +
            "     a.frontend_menu_id,\n" +
            "     a.frontend_menu_name,\n" +
            "     a.pid,\n" +
            "     a.frontend_menu_sort,\n" +
            "     b.role_id\n" +
            "   from sys_frontend_menu_table a, \n" +
            "     sys_role_table b, \n" +
            "     sys_role_frontend_menu_table c\n" +
            "   where  ( a.frontend_menu_id = c.frontend_menu_id or c.frontend_menu_id='*')\n" +
            "\t and b.role_id = c.role_id\n" +
            "     and b.role_id = #{roleId}\n" +
            ") t2 on t2.frontend_menu_id = t1.frontend_menu_id\n" +
            "   order by t1.frontend_menu_sort asc")
    /**
     * 根据roleId找菜单
     */
    List<SysRoleAndPermissionVo> getRoleAndMenuList(@Param("roleId") String roleId);



    @Select("select \n" +
            "  t1.backend_api_id as id,\n" +
            "  CASE t1.backend_api_url \n" +
            "  WHEN 'none' THEN t1.backend_api_name\n" +
            "  ELSE  CONCAT(t1.backend_api_name,' (',t1.backend_api_url,')')\n" +
            "  END as name ,\n" +
            "  t1.pid as pid,\n" +
            "  t2.role_id as role_id \n" +
            "from sys_backend_api_table t1 \n" +
            "left join\n" +
            "(\n" +
            "   select \n" +
            "     a.backend_api_id,\n" +
            "     a.backend_api_name,\n" +
            "     a.pid,\n" +
            "     a.backend_api_sort,\n" +
            "     b.role_id\n" +
            "   from sys_backend_api_table a, \n" +
            "     sys_role_table b, \n" +
            "     sys_role_backend_api_table c\n" +
            "   where  a.backend_api_id = c.backend_api_id\n" +
            "\t and b.role_id = c.role_id\n" +
            "     and b.role_id = #{roleId}\n" +
            ") t2 on t2.backend_api_id = t1.backend_api_id\n" +
            "   order by t1.backend_api_sort asc")
    /**
     * 根据roleId找API
     */
    List<SysRoleAndPermissionVo> getRoleAndApiList(@Param("roleId") String roleId);
}
package com.codingstudy.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codingstudy.login.entity.SysRoleTable;
import com.codingstudy.login.vo.SysRoleAndPermissionVo;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * (SysRoleTable)表服务接口
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-07 14:31:50
 */
public interface SysRoleTableService extends IService<SysRoleTable> {

    /**
     * 根据用户名称查询角色
     * @param userName
     * @return
     */
    List<String> getRolesByUserName(String userName);

    /**
     * 根据roleId找用户以及用户是否被设置在某个角色上，用在显示在用于角色设置处
     * @param roleId
     * @return
     */
    List<SysRoleAndPermissionVo> getRoleAndUserList(String roleId);

    /**
     * 根据roleId找菜单
     */
    List<SysRoleAndPermissionVo> getRoleAndMenuList(String roleId) ;

    /**
     * 根据roleId找API
     */
    List<SysRoleAndPermissionVo> getRoleAndApiList(String roleId);
}
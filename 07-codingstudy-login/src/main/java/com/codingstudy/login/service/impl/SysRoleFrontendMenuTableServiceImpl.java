package com.codingstudy.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codingstudy.login.dao.SysRoleFrontendMenuTableDao;
import com.codingstudy.login.entity.SysRoleFrontendMenuTable;
import com.codingstudy.login.entity.SysRoleUserTable;
import com.codingstudy.login.service.SysRoleFrontendMenuTableService;
import com.codingstudy.login.vo.SysRoleAndPermissionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * (SysRoleFrontendMenuTable)表服务实现类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-09 11:44:33
 */
@Service("sysRoleFrontendMenuTableService")
public class SysRoleFrontendMenuTableServiceImpl extends ServiceImpl<SysRoleFrontendMenuTableDao, SysRoleFrontendMenuTable> implements SysRoleFrontendMenuTableService {

    /**
     * 批量保存角色-菜单表
     * 该方法内有两个操作，先删除、后批量新增，因此存在事务控制
     * @param roleId
     * @param sysRoleAndPermissionVos
     * @return
     */
    @Override
    @Transactional
    public   boolean saveRoleMenu(String roleId, SysRoleAndPermissionVo... sysRoleAndPermissionVos) {

        System.out.println("roleId = " + roleId);

        //先删除数据
        this.delRoleId(roleId);
        //
        if(sysRoleAndPermissionVos !=null) {
            Set<SysRoleFrontendMenuTable> set = new HashSet<>();
            SysRoleFrontendMenuTable roleFrontendMenu = null;
            for (SysRoleAndPermissionVo roleVo : sysRoleAndPermissionVos) {
                roleFrontendMenu = new SysRoleFrontendMenuTable();
                //存储roleID和FrontendMenuId到多对对的中间表
                roleFrontendMenu.setRoleId(roleVo.getRoleId());
                roleFrontendMenu.setFrontendMenuId(roleVo.getId());
                set.add(roleFrontendMenu);
            }
            System.out.println("set = " + set);
            //再批量保存
            return this.saveBatch(set);
        }
        return  false;
    }

    /**
     * 根据RoleId删除
     * @param roleId
     * @return
     */
    private boolean delRoleId(String roleId) {
        LambdaQueryWrapper<SysRoleFrontendMenuTable> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRoleFrontendMenuTable::getRoleId,roleId);
        return this.remove(lambdaQueryWrapper);
    }
}
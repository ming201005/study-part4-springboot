package com.codingstudy.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codingstudy.login.dao.SysRoleBackendApiTableDao;
import com.codingstudy.login.entity.SysRoleBackendApiTable;
import com.codingstudy.login.entity.SysRoleFrontendMenuTable;
import com.codingstudy.login.service.SysRoleBackendApiTableService;
import com.codingstudy.login.vo.SysRoleAndPermissionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * (SysRoleBackendApiTable)表服务实现类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-09 12:11:56
 */
@Service("sysRoleBackendApiTableService")
public class SysRoleBackendApiTableServiceImpl extends ServiceImpl<SysRoleBackendApiTableDao, SysRoleBackendApiTable> implements SysRoleBackendApiTableService {

    /**
     * 批量保存角色-API表
     * 该方法内有两个操作，先删除、后批量新增，因此存在事务控制
     * @param roleId
     * @param sysRoleAndPermissionVos
     * @return
     */
    @Override
    @Transactional
    public   boolean saveRoleAip(String roleId, SysRoleAndPermissionVo... sysRoleAndPermissionVos) {

        System.out.println("roleId = " + roleId);

        //先删除数据
        this.delRoleId(roleId);
        //
        if(sysRoleAndPermissionVos !=null) {
            Set<SysRoleBackendApiTable> set = new HashSet<>();
            SysRoleBackendApiTable roleBackendApi = null;
            for (SysRoleAndPermissionVo roleVo : sysRoleAndPermissionVos) {
                roleBackendApi = new SysRoleBackendApiTable();
                //存储roleID和BackendApiId到多对对的中间表
                roleBackendApi.setRoleId(roleVo.getRoleId());
                roleBackendApi.setBackendApiId(roleVo.getId());
                set.add(roleBackendApi);
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
        LambdaQueryWrapper<SysRoleBackendApiTable> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRoleBackendApiTable::getRoleId,roleId);
        return this.remove(lambdaQueryWrapper);
    }
}
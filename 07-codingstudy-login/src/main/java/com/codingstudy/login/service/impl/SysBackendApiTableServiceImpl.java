package com.codingstudy.login.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codingstudy.login.dao.SysBackendApiTableDao;
import com.codingstudy.login.entity.SysBackendApiTable;
import com.codingstudy.login.service.SysBackendApiTableService;
import com.codingstudy.login.vo.SysBackendApiVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SysBackendApiTable)表服务实现类
 * 该类由EasyCode工具生成
 *
 * @author 小明哥
 * @since 2020-03-07 13:46:35
 */
@Service("sysBackendApiTableService")
public class SysBackendApiTableServiceImpl extends ServiceImpl<SysBackendApiTableDao, SysBackendApiTable> implements SysBackendApiTableService {

    /**
     * 根据角色查询API接口URL
     *
     * @param roles
     * @return
     */
    @Override
    public List<SysBackendApiTable> getApiUrlByRoles(String... roles) {
        return this.baseMapper.getApiUrlByRoles(roles);
    }

    /**
     * 根据用户名称查询API接口URL
     *
     * @param username
     * @return
     */
    @Override
    public List<SysBackendApiTable> getApiUrlByUserName(String username) {
        System.out.println("getApiUrlByUserName.................");
        return this.baseMapper.getApiUrlByUserName(username);
    }

    /**
     * 查所有（编辑使用）
     */
    @Override
    public List<SysBackendApiVo> getAllApiList() {
        return this.baseMapper.getAllApiList();
    }
}
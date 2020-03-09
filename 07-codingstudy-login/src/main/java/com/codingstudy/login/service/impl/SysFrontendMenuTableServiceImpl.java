package com.codingstudy.login.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codingstudy.login.dao.SysFrontendMenuTableDao;
import com.codingstudy.login.entity.SysFrontendMenuTable;
import com.codingstudy.login.service.SysFrontendMenuTableService;
import com.codingstudy.login.service.SysUserService;
import com.codingstudy.login.vo.SysFrontendVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (SysFrontendMenuTable)表服务实现类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-07 13:42:36
 */
@Service("sysFrontendMenuTableService")
public class SysFrontendMenuTableServiceImpl extends ServiceImpl<SysFrontendMenuTableDao, SysFrontendMenuTable> implements SysFrontendMenuTableService {

    /**
     * 查所有的前端菜单（编辑使用）
     */
    @Override
   public List<SysFrontendVo> getAllMenuList(){
       return this.baseMapper.getAllMenuList();
    }

    /**
     * 根据登录账号，获得前端展现的菜单
     * 控制前端菜单的权限
     * @param username
     * @return
     */
    @Override
    public List<SysFrontendMenuTable> getMenusByUserName(String username){
        return this.baseMapper.getMenusByUserName(username);
    }
}
package com.codingstudy.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codingstudy.login.entity.SysUserEntity;
import com.codingstudy.login.vo.SysUserVo;

public interface SysUserService extends IService<SysUserEntity>  {

    /**
     * 通过账号查询用户
     * @param username
     * @return
     */
    SysUserEntity getUserByUserName(String username);

    /**
     * 个性化验证登录
     * @param username 账号
     * @param rawPassword 原始密码
     * @return
     */
    boolean checkLogin(String username,String rawPassword) throws Exception;

    /**
     * 注册
     * @param sysUserVo
     * @return
     * @throws Exception
     */
    boolean register(SysUserVo sysUserVo) throws Exception;

    SysUserEntity voToPo(SysUserVo vo);

}

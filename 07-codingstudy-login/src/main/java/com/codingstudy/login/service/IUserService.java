package com.codingstudy.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codingstudy.login.entity.UserEntity;

public interface IUserService extends IService<UserEntity>  {

    /**
     * 通过账号查询用户
     * @param username
     * @return
     */
    UserEntity getUserByUserName(String username);

    /**
     * 个性化验证登录
     * @param username 账号
     * @param rawPassword 原始密码
     * @return
     */
    boolean checkLogin(String username,String rawPassword) throws Exception;

}

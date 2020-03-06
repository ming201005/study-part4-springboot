package com.codingstudy.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codingstudy.login.dao.UserMapper;
import com.codingstudy.login.entity.UserEntity;
import com.codingstudy.login.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Autowired
    UserMapper userMapper;

    //用户激活状态
    private static final int USER_STATE = 1;

    /**
     * 通过账号查询用户
     * @param username
     * @return
     */
    @Override
    public UserEntity getUserByUserName(String username) {
        LambdaQueryWrapper<UserEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //查询条件：全匹配账号名，和状态为1的账号
        lambdaQueryWrapper
                .eq(UserEntity::getUserName,username)
                .eq(UserEntity::getState,USER_STATE);

        //用getOne查询一个对象出来
        UserEntity user = this.getOne(lambdaQueryWrapper);

        return  user;
    }

    /**
     * 个性化验证登录
     * @param username 账号
     * @param rawPassword 原始密码
     * @return
     */
    @Override
    public boolean checkLogin(String username,String rawPassword) throws Exception {
        UserEntity userEntity = this.getUserByUserName(username);
        System.out.println("userEntity = " + userEntity);
        if (userEntity == null) {
            //System.out.println("checkLogin--------->账号不存在，请重新尝试！");
            //设置友好提示
            throw  new Exception("账号不存在，请重新尝试！");
        }else {
            //加密的密码
            String encodedPassword = userEntity.getPassWord();
            //和加密后的密码进行比配
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            if(!bCryptPasswordEncoder.matches(rawPassword,encodedPassword)) {
                //System.out.println("checkLogin--------->密码不正确！");
                //设置友好提示
                throw new Exception("密码不正确！");
            }else{
                return  true;
            }
        }
    }
}

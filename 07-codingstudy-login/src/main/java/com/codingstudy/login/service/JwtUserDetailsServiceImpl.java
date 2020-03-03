package com.codingstudy.login.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.codingstudy.login.dao.UserMapper;
import com.codingstudy.login.entity.RoleEntity;
import com.codingstudy.login.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author K. L. Mao
 * @create 2019/1/11
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.getUserByUserName(username);
        //人为的填充一些数据
        List<RoleEntity> roles = new ArrayList<>(2);
        roles.add(new RoleEntity("01","ADMIN"));
        roles.add(new RoleEntity("02","USER"));
        user.setRoles(roles);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", username));
        }
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(RoleEntity::getRoleName).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        System.out.println("here ....................user = " + user);
        return new JwtUser(user.getUserName(), user.getPassWord(), user.getState(), authorities);
    }

    /**
     * 根据用户名称查找用户
     * @param username
     * @return
     */
    private  UserEntity getUserByUserName(String username) {
        LambdaQueryWrapper<UserEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(UserEntity::getUserName,username);
        UserEntity user = mapper.selectOne(lambdaQueryWrapper);
        return  user;
    }
}

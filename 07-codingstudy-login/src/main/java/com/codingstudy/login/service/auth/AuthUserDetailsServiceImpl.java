package com.codingstudy.login.service.auth;

import com.codingstudy.login.entity.SysRoleTable;
import com.codingstudy.login.entity.SysUserEntity;
import com.codingstudy.login.service.SysRoleTableService;
import com.codingstudy.login.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 要实现UserDetailsService接口，这个接口是security提供的
 */
@Service
public class AuthUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleTableService roleService;

    /**
     * 通过账号查找用户、角色的信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity user = userService.getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", username));
        }else {
            //查找角色
            List<String> roles =  roleService.getRolesByUserName(username);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
            System.out.println("loadUserByUsername......user ===> " + user);
            return new AuthUser(user.getUserName(), user.getPassWord(), user.getState(), authorities);
        }
    }
}

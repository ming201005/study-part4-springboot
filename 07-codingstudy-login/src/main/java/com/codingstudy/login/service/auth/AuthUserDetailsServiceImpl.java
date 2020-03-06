package com.codingstudy.login.service.auth;

import com.codingstudy.login.entity.RoleEntity;
import com.codingstudy.login.entity.UserEntity;
import com.codingstudy.login.service.IUserService;
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
 * @author K. L. Mao
 * @create 2019/1/11
 */
@Service
public class AuthUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s.这个用户不存在", username));
        }else {
            //人为的填充一些数据
            List<RoleEntity> roles = new ArrayList<>();
            roles.add(new RoleEntity("01","ADMIN"));
            roles.add(new RoleEntity("02","USER"));
            user.setRoles(roles);

            List<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(RoleEntity::getRoleName).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

            System.out.println("here ....................user = " + user);
            return new AuthUser(user.getUserName(), user.getPassWord(), user.getState(), authorities);
        }
    }
}

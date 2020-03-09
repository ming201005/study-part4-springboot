package com.codingstudy.login.components;

import com.codingstudy.login.configuration.auth.MyAuthenticationException;
import com.codingstudy.login.configuration.auth.MyaccessDeniedException;
import com.codingstudy.login.service.SysBackendApiTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@Component
public class DynamicPermission {

    @Autowired
    SysBackendApiTableService service;



    /**
     * 判断有访问API的权限
     * @param request
     * @param authentication
     * @return
     * @throws MyaccessDeniedException
     */
    public boolean checkPermisstion(HttpServletRequest request,
                                   Authentication authentication) throws MyaccessDeniedException  {

        Object principal = authentication.getPrincipal();
        System.out.println("DynamicPermission principal = " + principal);

        if(principal instanceof UserDetails) {

            UserDetails userDetails = (UserDetails) principal;
            //得到当前的账号
            String username = userDetails.getUsername();
            //Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

            // System.out.println("DynamicPermission  username = " + username);
            //通过账号获取资源鉴权
            List<String> apiUrls = service.getApiUrlByUserName(username);

            AntPathMatcher antPathMatcher = new AntPathMatcher();
            //当前访问路径
            String requestURI = request.getRequestURI();

            // System.out.println("DynamicPermission requestURI = " + requestURI);

            //判断当前路径中是否在资源鉴权中
            boolean rs = apiUrls.stream().anyMatch(api->antPathMatcher.match(api,requestURI));
            if (!rs) {
                throw  new MyaccessDeniedException("您没有访问该API的权限！");
            }else {
                return rs;
            }

        }else{
            throw  new MyaccessDeniedException("不是UserDetails类型！");
        }
    }
}


























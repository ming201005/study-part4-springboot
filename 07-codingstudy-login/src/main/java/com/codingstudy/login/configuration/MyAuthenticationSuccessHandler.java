package com.codingstudy.login.configuration;

import com.alibaba.fastjson.JSONObject;

import com.baomidou.mybatisplus.extension.api.R;
import com.codingstudy.login.components.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功操作
 */
@Component
@Slf4j
public class MyAuthenticationSuccessHandler extends JSONAuthentication implements AuthenticationSuccessHandler {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        //取得账号信息
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //
        System.out.println("userDetails = " + userDetails);
        //取token
        jwtTokenUtil = new JwtTokenUtil();
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String,Object> map = new HashMap<>();
        map.put("username",userDetails.getUsername());
        map.put("auth",userDetails.getAuthorities());
        map.put("token",token);
        //装入token
        R<Map<String,Object>> data = R.ok(map);
        //输出
        this.WriteJSON(request, response, data);

    }
}

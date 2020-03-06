package com.codingstudy.login.configuration.auth;

import com.codingstudy.login.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 重写UsernamePasswordAuthenticationFilter过滤器
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    IUserService userService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {

            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            //取authenticationBean
            Map<String, String> authenticationBean = null;
            //用try with resource，方便自动释放资源
            try (InputStream is = request.getInputStream()) {
                authenticationBean = mapper.readValue(is, Map.class);
            } catch (IOException e) {
                //将异常放到自定义的异常类中
                throw  new MyAuthenticationException(e.getMessage());
            }
            try {
                if (!authenticationBean.isEmpty()) {
                    //获得账号、密码
                    String username = authenticationBean.get(SPRING_SECURITY_FORM_USERNAME_KEY);
                    String password = authenticationBean.get(SPRING_SECURITY_FORM_PASSWORD_KEY);
                    //可以验证账号、密码
                    //System.out.println("username = " + username);
                    //System.out.println("password = " + password);

                    //检测账号、密码是否存在
                    if (userService.checkLogin(username, password)) {
                        //将账号、密码装入UsernamePasswordAuthenticationToken中
                        authRequest = new UsernamePasswordAuthenticationToken(username, password);
                        setDetails(request, authRequest);
                        return this.getAuthenticationManager().authenticate(authRequest);
                    }
                }
            } catch (Exception e) {
                throw new MyAuthenticationException(e.getMessage());
            }
            return null;
        } else {
            return this.attemptAuthentication(request, response);
        }
    }
}

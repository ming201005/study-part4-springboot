package com.codingstudy.login;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class LoginApplicationTests {

    @Test
    public void testCode()throws Exception{
        //UTF-8字符集进行解码
        String str = "%E5%BC%A0%E4%B8%89";
        System.out.println(URLDecoder.decode(str, "UTF-8"));
        //GBK字符集进行解码
        System.out.println(URLDecoder.decode(str, "GBK"));

        System.out.println("-----------------------------------------------");
        //utf-8字符集
        System.out.println(URLEncoder.encode("李四", "UTF-8"));
        //GBK字符集
        System.out.println(URLEncoder.encode("李四", "GBK"));
    }


}

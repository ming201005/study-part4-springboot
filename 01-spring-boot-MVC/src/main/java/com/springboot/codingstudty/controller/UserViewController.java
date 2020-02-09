package com.springboot.codingstudty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
/**
 * 描述：用户页面控制
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-13 09:19
 * @see
 */
@Controller
public class UserViewController {

    @GetMapping("json")
    @ResponseBody
    public  Map<String,Object> getJson(){
        //模拟一个用户
        Map<String,Object> user = new HashMap<> ();
        user.put ("id",2);
        user.put ("name","小兰");
        user.put ("age",19);
        //返回这个用户
        return user;
    }


    /**
     * 返回ModelAndView
     * @return
     */
    @RequestMapping("/uc/info")
    public ModelAndView userInfo(){
        ModelAndView modelAndView = new ModelAndView ();
        //跳转到user.html页面
        modelAndView.setViewName ("user");
        return modelAndView;
    }

    /**
     * 返回String
     * @return
     */
    @GetMapping("/uc/info2")
    public String userInfo2(){
        return "user";
    }

}

package com.springboot.codingstudty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 测试 @Controller
 */
@Controller
public class CodingStudyIndexController {

    /**
     *  没有数据渲染的返回
     * @return
     */
    @RequestMapping("/")
    //@GetMapping
    public String index01() {
        return "index";
    }

    /**
     * 返回ModelAndView
     * 通过ModelAndView可以带入数据，并渲染到页面
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView ();
        //可以设置数据
        String data = "这个数据来自IndexController...";
        modelAndView.addObject("data",data);
        //跳转到index.html页面
        modelAndView.setViewName ("index");
        return modelAndView;
    }

}

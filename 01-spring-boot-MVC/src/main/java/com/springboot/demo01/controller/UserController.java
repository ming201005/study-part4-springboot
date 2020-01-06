package com.springboot.demo01.controller;

import com.springboot.demo01.configuration.CallBean;
import com.springboot.demo01.configuration.UserAction;
import com.springboot.demo01.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：本类有什么功能？
 * 1、TODO
 * 2、TODO
 * 3、TODO
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-12 20:50
 * @see
 */
@RestController
public class UserController {
    /**
     * 注意，加了@Autowired就相当于new UserAction
     */
    //@Resource(name = "userAction1")
    //UserAction userAction;

    @Autowired
    @Qualifier(value = "userAction1")
    UserAction userAction;

    @Autowired
    CallBean callBean;

    @Value("${server.port}")
    public  String  port;

    public static  String DATA_SOURCE_URL;

    /**
     * @value给静态变量赋值，需要增加set方法
     * 方法名称和参数可任意。
     * @param val
     */
    @Value ("${spring.datasource.url}")
    public void setDataSourceUrl(String val){
        DATA_SOURCE_URL = val;
    }



    @GetMapping("user")
    public  Map<String,Object> getUser(){
        //模拟一个用户
        Map<String,Object> user = new HashMap<> ();
        user.put ("id",1);
        user.put ("name","张三");
        user.put ("age",18);
        //返回这个用户
        return user;
    }

    @GetMapping("val")
    public String getVal(){
        return "端口号="+ port+",DataSource URL ="+DATA_SOURCE_URL;
    }

    @GetMapping("user/play")
    public String play() {
        return "@Autowired获取bean==>"+userAction.display ();
    }


    @GetMapping("user/play2")
    public String play2()
    {
        //注册bean时的名字，是一个字符串
        String beanName = "userAction";
        UserAction userAction = callBean.getApplicationContext ().getBean (beanName,UserAction.class);
        String msg = userAction.display ();
        return "手工获取bean==》"+msg;
    }

    @GetMapping("testRp")
    public String testRp(
            @RequestParam("id") String id,
            @RequestParam(value="userName", required=false) String userName,
            @RequestParam(value="age", required=false) int age)
    {

        return "id="+id+"，userName="+userName+"，age="+age;
    }

    @GetMapping("testPv/{id}/{name}")
    public String testPv(
            @PathVariable("id") String id,
            @PathVariable(value = "name",required = false) String userName)
    {

        return "id="+id+"，userName="+userName;
    }

    @PostMapping("user/save")
    public String save(
            @RequestParam("id") String id,
            @RequestParam(value="age", required=false) int age,
            @RequestBody User user)
    {

        return "id="+id+"，age="+age+"。user对象==>"+user.toString ();
    }
}

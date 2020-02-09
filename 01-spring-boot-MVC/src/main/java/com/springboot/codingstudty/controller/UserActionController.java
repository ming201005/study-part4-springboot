package com.springboot.codingstudty.controller;

import com.springboot.codingstudty.configuration.CreateBean;
import com.springboot.codingstudty.configuration.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试 @Autowired、自定义过去bean、@Configuration等
 */
@RestController
public class UserActionController {

    //加了Autowired注解后，不需要new对象
    @Autowired
    UserAction userAction;

    @Autowired
    CreateBean createBean;

    /*
    @Resource(name = "userAction1")
    UserAction userAction;
    //或@Autowired+@Qualifier
    @Autowired
    @Qualifier(value = "userAction1")
    UserAction userAction;
    */

    @GetMapping("user/display")
    public  String getDisplay() {
       return userAction.display();
    }

    @GetMapping("user/display2")
    public String getDisplay2()
    {
        //注册bean时的名字，是一个字符串
        String beanName = "userAction";
        UserAction userAction = createBean.getApplicationContext ()
                .getBean (beanName,UserAction.class);
        String msg = userAction.display ();
        return "手工获取bean==》"+msg;
    }
}


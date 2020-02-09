package com.springboot.codingstudty.controller;

import com.springboot.codingstudty.entity.User;
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
@RequestMapping("/admin/user/")
public class UserController {

    @GetMapping
    public Map<String,Object> getUser() {
        Map<String,Object> user =  new HashMap<>();
        user.put("id",1);
        user.put("name","ming206");
        return  user;
    }

    @PostMapping
    public boolean insert(@RequestBody User user) {
        //insert ...
        return true;
    }

    @PutMapping
    public boolean update(@RequestBody User user) {
        //update .....
        return true;
    }

    @DeleteMapping
    public boolean del(@PathVariable("id") String id) {
        System.out.println(id);
        //delete ....
        return  true;
    }

    @PostMapping("save")
    public String save(
            @RequestParam("id") String id,
            @RequestParam(value="age", required=false) int age,
            @RequestBody User user){
        return "id="+id+"，age="+age+"。user对象==>"+user.toString ();
    }



}

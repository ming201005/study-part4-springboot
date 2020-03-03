package com.codingstudy.login.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductController {

    @GetMapping("get")
    public String get(@RequestParam Map params) {
        System.out.println("params = " + params);
        return "helle...";
    }

    @GetMapping
    public List<Map<String,Object>> getProduct() {
        List<Map<String,Object>> list = new ArrayList<>();

        Map<String,Object> product = new HashMap();
        product.put("id",1);
        product.put("name","梨子");
        list.add(product);

        product = new HashMap();
        product.put("id",2);
        product.put("name","桃子");
        list.add(product);

        product = new HashMap();
        product.put("id",3);
        product.put("name","香蕉");
        list.add(product);

        return  list;
    }

}

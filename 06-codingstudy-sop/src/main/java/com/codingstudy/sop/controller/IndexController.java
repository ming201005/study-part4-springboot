package com.codingstudy.sop.controller;

import com.codingstudy.sop.aspect.LogAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("index")
public class IndexController {

    @GetMapping
    @LogAnnotation
    public String index() {
        return "this is index page";
    }
}

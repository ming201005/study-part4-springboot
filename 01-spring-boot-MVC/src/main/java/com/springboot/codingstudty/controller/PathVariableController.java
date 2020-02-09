package com.springboot.codingstudty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 @RequestParam
 */
@RestController
public class PathVariableController {

    @GetMapping("path/{id}/{name}")
    public String pathVar(
            @PathVariable("id") String id,
            @PathVariable(value = "name",required = false) String userName)
    {

        return "id="+id+"，userName="+userName;
    }
}

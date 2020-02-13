package com.codingstudy.sop.service;

import com.codingstudy.sop.aspect.LogAnnotation;
import com.codingstudy.sop.aspect.LogAspect;
import com.fasterxml.jackson.databind.util.CompactStringObjectMap;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {
    Log log = LogFactory.getLog(TestService.class);

    @LogAnnotation("getUser")
    public Map<String, Object> getUser(int id, String name, int age) {

        int a = 10;
        int b = 50;
        int c = a/b;
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("age",age);
        map.put("price","河北");
        //log.info("..............getUser方法");
        System.out.println("getUser方法内部。。。。。");
        return map;
    }
}

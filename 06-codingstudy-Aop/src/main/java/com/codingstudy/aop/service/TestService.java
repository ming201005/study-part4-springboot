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

    public Map<String, Object> getUser(int id) {
        //虚构一个用户信息
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name","ming206");
        map.put("age","25岁");
        map.put("addr","重庆");
        log.info("getUser方法内部。。。。。");
        //System.out.println("getUser方法内部。。。。。");
        return map;
    }


    @LogAnnotation("getUser02")
    public Map<String, Object> getUser02(int id) {
        //虚构一个用户信息
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name","ming206");
        map.put("age","25岁");
        map.put("addr","重庆");
        System.out.println("getUser02方法内部。。。。。");
        return map;
    }
}

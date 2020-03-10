package com.codingstudy.login.service;

import com.codingstudy.login.entity.SysBackendApiTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysBackendApiTableServiceTest {

    @Autowired
    SysBackendApiTableService service;

    /**
     * 插入数据
     */
    @Test
    public void add() {
        Set<SysBackendApiTable> list = new HashSet<>();
        //list.add(new SysBackendApiTable(null,"系统管理","none","",2,"none"));
        //list.add(new SysBackendApiTable(null,"用户查询","/user/search","",1,"get"));
        //list.add(new SysBackendApiTable(null,"用户注册","/user/register","",2,"post"));
        //list.add(new SysBackendApiTable(null,"用户编辑","/user/edit","",3,"put"));
        list.add(new SysBackendApiTable(null,"所有","","/**","GET",0,"admin特有"));
        service.saveBatch(list);
    }

    /**
     * 通过角色查询api
     */
    @Test
    void selectAPIbByRoles(){
      List<SysBackendApiTable> list =  service.getApiUrlByRoles("ROLE_ADMIN");
      list.forEach(System.out::println);
    }

    /**
     * 通过账号查询api
     */
    @Test
    void selectAPIByUserName() {
        List<SysBackendApiTable> list =  service.getApiUrlByUserName("张三");
        list.forEach(System.out::println);
    }
}
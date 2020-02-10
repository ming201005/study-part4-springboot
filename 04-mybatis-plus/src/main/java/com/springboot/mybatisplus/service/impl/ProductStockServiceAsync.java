package com.springboot.mybatisplus.service.impl;

import com.springboot.mybatisplus.service.IProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * 多线程
 */
@Service
public class ProductStockServiceAsync   {

    @Autowired
    IProductStockService service;
    /**
     * 购买商品
     * Async 表明是异步方法
     */
    @Async
    public Future<String> buyAsync(int productId, int buyNum) {
        System.out.println("线程=" + Thread.currentThread().getName());
        service.buy(productId,buyNum);
        return new AsyncResult<>("抢购完成！");
    }
}


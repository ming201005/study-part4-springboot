package com.springboot.mybatisplus.service;

import com.springboot.mybatisplus.service.impl.ProductStockServiceAsync;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.concurrent.Future;

@SpringBootTest
class ProductStockServiceAsyncTest {

    @Autowired
    ProductStockServiceAsync serviceAsync;

    /**
     * 模拟抢购下单，用多线程模拟多人抢购
     */
    @Test
    void testBuyProductAsync() {
        System.out.println("3个人开始抢购。。。。");
        //大家都在抢购同一款商品
        int productId = 3;
        //3个人同时抢购
        Future<String> future01 = serviceAsync.buyAsync(productId,3);
        Future<String> future02 = serviceAsync.buyAsync(productId,1);
        Future<String> future03 = serviceAsync.buyAsync(productId,2);
        while (true) {
            if(future01.isDone() &&future02.isDone() &&future03.isDone()){
                break;
            }
            try{
                Thread.sleep(1000);
            }catch (Exception e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        }
        System.out.println("抢购全部完毕。。。。");

        //模拟有5个人抢购
//        for (int i = 0; i <5; i++) {
//            //每个人购买数量不一样，随机的
//            double r = Math.random();
//            int num = (int) (r*10+1);
//            //System.out.println("购买数量==》" + num);
//            serviceAsync.buyAsync(productId,num);
//            try{
//                Thread.sleep(1000);
//            }catch (Exception e) {
//
//            }
//        }
    }
}
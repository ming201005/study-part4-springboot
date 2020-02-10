package com.springboot.mybatisplus.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductStockServiceTest {

    @Autowired
    IProductStockService service;

    /**
     * 下单，单人
     */
    @Test
    void testBuyProduct() {
        //大家都在抢购同一款商品
        int productId = 3;
        service.buy(productId,5);
    }
}
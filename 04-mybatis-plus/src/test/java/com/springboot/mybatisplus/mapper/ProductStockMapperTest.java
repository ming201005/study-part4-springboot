package com.springboot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.mybatisplus.entity.ProductStock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 描述：测试ProductStockMapper
 *
 * @author ming
 * @version 1.0
 * @date 2020-01-03 23:32
 * @see
 */
@SpringBootTest
class ProductStockMapperTest {
    @Autowired
    ProductStockMapper mapper;

    /**
     * 模拟抢购下单
     */
    @Test
    void testBuyProduct() {
        //假设购买的商品id=1
        int productId = 1;
        //假设购买的件数是 5件
        int buyNum = 5;
        //先查询库存量够不够
        //查询出id=1的商品库存信息
        QueryWrapper<ProductStock> queryWrapper = new QueryWrapper<> ();
        queryWrapper.eq ("product_id", productId);

        ProductStock productStock =  mapper.selectOne (queryWrapper);
        int productNum = productStock.getProductNum ();
        //至少保证库存量够
        if(productNum>0 && productNum>=buyNum) {

            ProductStock newProductStock = new ProductStock();
            //设置属性值
            newProductStock.setId (productStock.getId ());
            //减库存
            newProductStock.setProductNum (productNum-buyNum);
            // 执行更新，在实体类中使用 @Version注解是
            // 自动达到productStock.getVersion ()+1目的
            // 因此，下面的setVersion是不用+1的。
            newProductStock.setVersion (productStock.getVersion ());

            //执行更新操作
            //SQL语句会是：update product_stock
            //           set product_num = xxx,
            //               version = version+1
            //           Where id = xxx and  version = version
            int rs =  mapper.updateById (newProductStock);
            if(rs>0) {
               System.out.println ("抢购成功！");
            }else{
               System.out.println ("抢购失败！");
            }
        }
    }
}
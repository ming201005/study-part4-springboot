package com.springboot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.mybatisplus.entity.ProductStock;
import com.springboot.mybatisplus.mapper.ProductStockMapper;
import com.springboot.mybatisplus.service.IProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductStockService implements IProductStockService {

    @Autowired
    private ProductStockMapper mapper;

    /**
     * 购买商品，实现乐观所
     */
    @Override
    public void buy(int productId, int buyNum) {
        //先查询库存量够不够
        //查询出id=1的商品库存信息
        QueryWrapper<ProductStock> queryWrapper = new QueryWrapper<> ();
        queryWrapper.eq ("product_id", productId);
        ProductStock productStock =  mapper.selectOne (queryWrapper);
        int productNum = productStock.getProductNum ();

        System.out.println("您抢购商品ID【"+productId+"】,购买【"
                + buyNum + "】件，库存有【" + productNum + "】件");
        //至少保证库存量够
        if(productNum>0 && productNum>= buyNum) {
            System.out.println("有条件抢购……");
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
        }else {
            System.out.println("您购买商品" + buyNum + "件，库存只有"
                    + productNum + "件。商品不足不能抢购！");
        }
    }
}

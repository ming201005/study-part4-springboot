package com.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

/**
 * 描述：商品库存
 *
 * @author ming
 * @version 1.0
 * @date 2020-01-03 23:24
 * @see
 */
@TableName("product_stock")
public class ProductStock {

    /*
        id              库存编号       int类型
        product_id      商品编号       varchar类型
        product_num    商品库存量     int类型
        version          版本号        int 类型
     */
    @TableId(value = "id",type = IdType.AUTO)
    int id;
    String productId;
    int productNum;

    //版本控制
    @Version
    int version;

    public ProductStock() {
    }

    public ProductStock(int id, String productId, int productNum, int version) {
        this.id = id;
        this.productId = productId;
        this.productNum = productNum;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ProductStock{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productNum=" + productNum +
                ", version=" + version +
                '}';
    }
}

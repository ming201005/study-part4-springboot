package com.codingstudy.login.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.math.BigDecimal;

@TableName("product_table")
public class ProductEntity extends Model<ProductEntity> {
    @TableId(type = IdType.UUID)
    String productId;
    String productName;
    int num;
    BigDecimal price;

    public ProductEntity() {
    }

    public ProductEntity(String productId, String productName, int num, BigDecimal price) {
        this.productId = productId;
        this.productName = productName;
        this.num = num;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }
}

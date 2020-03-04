package com.codingstudy.login.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.codingstudy.login.dao.ProductMapper;
import com.codingstudy.login.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductMapper mapper;

    /**
     * 新增数据
     * @param productEntity
     * @return
     */
    @PostMapping
    public R<ProductEntity> add(@RequestBody ProductEntity productEntity) {
        //here....
        System.out.println("productEntity = " + productEntity);
        int rs = mapper.insert(productEntity);
        return  R.ok(productEntity);
    }

    /**
     * 查询所有数据集
     * @return
     */
    @GetMapping
    public R<List<ProductEntity>> getProduct() {

        List<ProductEntity> list =  mapper.selectList(null);
        return  R.ok(list);
    }

}

package com.codingstudy.ajax.ajax.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codingstudy.ajax.ajax.entity.Fruit;
import com.codingstudy.ajax.ajax.service.FruitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Fruit)表控制层
 *
 * @author makejava
 * @since 2020-01-30 00:08:04
 */
@RestController
@RequestMapping("fruit")
public class FruitController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private FruitService fruitService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param fruit 查询实体
     * @return 所有数据
     */
    @GetMapping
    @CrossOrigin
    public R selectAll(Page<Fruit> page, Fruit fruit) {
        return success(this.fruitService.page(page, new QueryWrapper<>(fruit)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @CrossOrigin
    public R selectOne(@PathVariable Serializable id) {
        return success(this.fruitService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param fruit 实体对象
     * @return 新增结果
     */
    @PostMapping
    @CrossOrigin
    public R insert(@RequestBody Fruit fruit) {
        return success(this.fruitService.save(fruit));
    }

    /**
     * 修改数据
     *
     * @param fruit 实体对象
     * @return 修改结果
     */
    @PutMapping
    @CrossOrigin
    public R update(@RequestBody Fruit fruit) {
        return success(this.fruitService.updateById(fruit));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @CrossOrigin
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.fruitService.removeByIds(idList));
    }
}
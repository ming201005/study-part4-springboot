package com.codingstudy.login.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codingstudy.login.entity.SysBackendApiTable;
import com.codingstudy.login.service.SysBackendApiTableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (SysBackendApiTable)表控制层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-07 13:46:35
 */
@RestController
@RequestMapping("sysBackendApiTable")
public class SysBackendApiTableController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SysBackendApiTableService sysBackendApiTableService;

    /**
     * 分页查询所有数据
     * @return 所有数据
     */
    @GetMapping
    public R selectAll() {
        return success(this.sysBackendApiTableService.getAllApiList());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysBackendApiTableService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysBackendApiTable 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysBackendApiTable sysBackendApiTable) {
        //如果没有父级，设置为url=none
        if (StringUtils.isEmpty(sysBackendApiTable.getPid())) {
            sysBackendApiTable.setBackendApiUrl("none");
        }
        return success(this.sysBackendApiTableService.save(sysBackendApiTable));
    }

    /**
     * 修改数据
     *
     * @param sysBackendApiTable 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysBackendApiTable sysBackendApiTable) {
        return success(this.sysBackendApiTableService.updateById(sysBackendApiTable));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.sysBackendApiTableService.removeByIds(idList));
    }
}
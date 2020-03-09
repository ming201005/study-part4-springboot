package com.codingstudy.login.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (SysRoleBackendApiTable)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-09 12:11:56
 */
@SuppressWarnings("serial")
public class SysRoleBackendApiTable extends Model<SysRoleBackendApiTable> {

    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private String roleId;
    
    private String backendApiId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getBackendApiId() {
        return backendApiId;
    }

    public void setBackendApiId(String backendApiId) {
        this.backendApiId = backendApiId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }
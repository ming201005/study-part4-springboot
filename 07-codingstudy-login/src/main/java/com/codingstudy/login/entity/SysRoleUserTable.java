package com.codingstudy.login.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * (SysRoleUserTable)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-08 23:03:13
 */
@SuppressWarnings("serial")
public class SysRoleUserTable extends Model<SysRoleUserTable> {

    @TableId(type = IdType.AUTO)
    private int id;

    private String roleId;
    
    private String userId;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
    }
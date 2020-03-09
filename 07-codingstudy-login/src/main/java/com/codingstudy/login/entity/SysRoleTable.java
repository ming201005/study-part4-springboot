package com.codingstudy.login.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (SysRoleTable)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-07 14:31:50
 */
@SuppressWarnings("serial")
public class SysRoleTable extends Model<SysRoleTable> {

    @TableId(type = IdType.UUID)
    private String roleId;
    
    private String roleName;
    
    private String description;


    public SysRoleTable() {
    }

    public SysRoleTable(String roleId, String roleName) {
        this.roleId = roleId;
        this.tranRoleName(roleName);
    }

    public SysRoleTable(String roleId, String roleName, String description) {
        this.roleId = roleId;
        this.tranRoleName(roleName);
        this.description = description;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.tranRoleName(roleName);
    }

    private void tranRoleName(String roleName) {
        if (roleName.indexOf("ROLE_") == -1) {
            this.roleName = "ROLE_" + roleName;
        } else {
            this.roleName = roleName;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "SysRoleTable{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


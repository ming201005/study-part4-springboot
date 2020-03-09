package com.codingstudy.login.vo;

/**
 * 角色和鉴权资源的VO
 * 如：角色和用户VO
 *     角色和API
 *     角色和前端菜单
 * 他们都可以使用该VO来转换并展现给前端
 */
public class SysRoleAndPermissionVo {
    String  id;
    String  name;
    String  roleId;
    String  pid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "SysUserRoleVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", roleId='" + roleId + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }
}

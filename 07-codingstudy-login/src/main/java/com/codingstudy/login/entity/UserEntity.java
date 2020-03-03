package com.codingstudy.login.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;


@TableName("user_table")
public class UserEntity {

    @TableId(value = "user_id", type = IdType.UUID)
    String userId;

    String userName;

    String passWord;

    private Integer state;

    String description;

    @TableField(exist = false)
    List<RoleEntity> roles;

    public UserEntity() {
    }

    public UserEntity(String userId, String userName, String passWord, Integer state, String description) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.state = state;
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", state=" + state +
                ", description='" + description + '\'' +
                ", roles" + roles +
                '}';
    }
}

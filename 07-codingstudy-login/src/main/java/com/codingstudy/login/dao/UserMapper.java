package com.codingstudy.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codingstudy.login.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper  extends BaseMapper<UserEntity> {

}

package com.codingstudy.ajax.ajax.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codingstudy.ajax.ajax.dao.FruitDao;
import com.codingstudy.ajax.ajax.entity.Fruit;
import com.codingstudy.ajax.ajax.service.FruitService;
import org.springframework.stereotype.Service;

/**
 * (Fruit)表服务实现类
 *
 * @author makejava
 * @since 2020-01-30 00:08:04
 */
@Service("fruitService")
public class FruitServiceImpl extends ServiceImpl<FruitDao, Fruit> implements FruitService {

}
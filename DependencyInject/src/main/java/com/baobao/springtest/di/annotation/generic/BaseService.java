package com.baobao.springtest.di.annotation.generic;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author baobao
 * @create 2020-01-20 9:32
 * @description 泛型依赖注入的Service基类
 */
public class BaseService<T> {
    //自动装配Dao，这个属性会被其子类继承
    @Autowired
    private BaseDao baseDao;

    public void add(T t){
        System.out.println(this.getClass().getName() + ":" + t);
        baseDao.add(t);
    }
}

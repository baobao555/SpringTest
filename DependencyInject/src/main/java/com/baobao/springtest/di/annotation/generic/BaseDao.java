package com.baobao.springtest.di.annotation.generic;

/**
 * @author baobao
 * @create 2020-01-20 9:32
 * @description 泛型依赖注入的Dao基类
 */
public class BaseDao<T> {
    public void add(T t){
        System.out.println(this.getClass().getName() + ":" + t);
    }
}

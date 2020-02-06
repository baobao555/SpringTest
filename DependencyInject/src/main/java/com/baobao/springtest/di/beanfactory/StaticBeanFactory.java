package com.baobao.springtest.di.beanfactory;

import com.baobao.springtest.di.bean.Address;


/**
 * @author baobao
 * @create 2020-01-15 10:49
 * @description 静态bean工厂
 *
 * 无需实例化，配置静态工厂的静态方法返回bean
 */
public class StaticBeanFactory {
    public static Address getAddress(String province){
        return new Address("China", province);
    }
}

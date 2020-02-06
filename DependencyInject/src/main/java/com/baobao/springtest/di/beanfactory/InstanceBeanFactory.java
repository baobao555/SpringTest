package com.baobao.springtest.di.beanfactory;

import com.baobao.springtest.di.bean.Address;

/**
 * @author baobao
 * @create 2020-01-15 10:49
 * @description 实例bean工厂
 *
 * 先实例化bean工厂，再利用bean工厂的方法产生bean
 */
public class InstanceBeanFactory {
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String country;

    public Address getAddress(String province){
        return new Address(this.country, province);
    }
}

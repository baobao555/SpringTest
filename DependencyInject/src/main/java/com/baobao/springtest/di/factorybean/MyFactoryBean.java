package com.baobao.springtest.di.factorybean;

import com.baobao.springtest.di.bean.Address;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author baobao
 * @create 2020-01-15 14:37
 * @description 自定义FactoryBean
 *
 * FactoryBean：Spring提供的一个接口，方便实现一个bean工厂
 */
public class MyFactoryBean implements FactoryBean<Address> {
    private String country;
    private String province;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 调用容器的getBean会执行该方法返回bean
     * @return bean对象
     * @throws Exception
     */
    @Override
    public Address getObject() throws Exception {
        return new Address(country,province);
    }

    /**
     * 返回bean的类型
     * @return bean的Class类型
     */
    @Override
    public Class<?> getObjectType() {
        return Address.class;
    }

    /**
     * 返回是否单例
     * @return 工厂生成的bean是否单例
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}

package com.baobao.springtest.di.test;

import com.baobao.springtest.di.bean.Address;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baobao
 * @create 2020-01-14 16:25
 * @description
 */
public class FactoryBeanTest {

    private ApplicationContext context;

    @Before
    public void initContext(){
        //初始化ioc容器
        context = new ClassPathXmlApplicationContext("applicationContext-factoryBean.xml");
    }

    @Test
    public void testFactoryBean(){
        Address address = context.getBean("address", Address.class);
        System.out.println(address);
    }
}

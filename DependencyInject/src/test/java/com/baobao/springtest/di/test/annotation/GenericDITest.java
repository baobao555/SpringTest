package com.baobao.springtest.di.test.annotation;

import com.baobao.springtest.di.annotation.UserController;
import com.baobao.springtest.di.annotation.generic.AddressService;
import com.baobao.springtest.di.bean.Address;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baobao
 * @create 2020-01-20 9:02
 * @description
 */
public class GenericDITest {
    private ApplicationContext context;

    @Before
    public void initContext(){
        //初始化ioc容器
        context = new ClassPathXmlApplicationContext("annotation/applicationContext-generic.xml");
    }

    @Test
    public void testGenericeDI(){
        AddressService addressService = context.getBean("addressService", AddressService.class);
        addressService.add(new Address("China", "ZJ"));
    }
}

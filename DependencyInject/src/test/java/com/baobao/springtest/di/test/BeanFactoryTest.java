package com.baobao.springtest.di.test;

import com.baobao.springtest.di.bean.Address;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baobao
 * @create 2020-01-14 16:25
 * @description
 */
public class BeanFactoryTest {

    private ApplicationContext context;

    @Before
    public void initContext(){
        //初始化ioc容器
        context = new ClassPathXmlApplicationContext("applicationContext-beanFactory.xml");
    }

    @Test
    public void testBeanFactory(){
        Address address1 = context.getBean("address1", Address.class);
        System.out.println("StacticBeanFactory:" +  address1);

        Address address2 = context.getBean("address2", Address.class);
        System.out.println("InstanceBeanFactory:" + address2);

    }
}

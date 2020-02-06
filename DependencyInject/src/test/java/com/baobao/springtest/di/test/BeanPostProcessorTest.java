package com.baobao.springtest.di.test;

import com.baobao.springtest.di.bean.Address;
import com.baobao.springtest.di.bean.Person;
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
public class BeanPostProcessorTest {

    //声明成ConfigurableApplicationContext，才有关闭容器的方法
    private ConfigurableApplicationContext context;

    @Before
    public void initContext(){
        //初始化ioc容器
        context = new ClassPathXmlApplicationContext("applicationContext-beanPostProcessor.xml");
    }

    @Test
    public void testBeanPostProcessor(){
        Address address = context.getBean("address", Address.class);
        System.out.println(address);
        //关闭容器，bean的destroy-method被调用
        context.close();
    }
}

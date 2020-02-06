package com.baobao.springtest.di.test;

import com.baobao.springtest.di.bean.Address;
import com.baobao.springtest.di.bean.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baobao
 * @create 2020-01-14 16:25
 * @description
 */
public class SpELTest {
    private ApplicationContext context;

    @Before
    public void initContext(){
        //初始化ioc容器
        context = new ClassPathXmlApplicationContext("applicationContext-spel.xml");
    }

    @Test
    public void testSpEL(){
        Address address = context.getBean("address", Address.class);
        Person person = context.getBean("person", Person.class);
        System.out.println(address);
        System.out.println(person);
    }
}

package com.baobao.springtest.di.test;

import com.baobao.springtest.di.bean.Address;
import com.baobao.springtest.di.bean.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baobao
 * @create 2020-01-14 16:01
 * @description 测试scope
 */
public class ScopeTest {
    private ApplicationContext context;

    @Before
    public void initContext(){
        //初始化ioc容器
        context = new ClassPathXmlApplicationContext("applicationContext-scope.xml");
    }

    @Test
    public void testScope(){
        Person person1 = context.getBean("person", Person.class);
        Person person2 = context.getBean("person", Person.class);
        System.out.println("person1==person2:" + (person1 == person2));

        Address address1 = context.getBean("address", Address.class);
        Address address2 = context.getBean("address", Address.class);
        System.out.println("address1==address2:" + (address1 == address2));
    }
}

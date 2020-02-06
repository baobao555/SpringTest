package com.baobao.springtest.di.test;

import com.baobao.springtest.di.bean.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baobao
 * @create 2020-01-10 17:26
 * @description 测试依赖注入
 */
public class DITest {
    private ApplicationContext context;

    @Before
    public void initContext(){
        //初始化ioc容器
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    //通过property标签注入属性
    @Test
    public void test1(){
        Person person1 = context.getBean("person1", Person.class);
        System.out.println(person1);
    }

    //通过构造方法注入属性
    @Test
    public void test2(){
        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2);
    }

    //注入引用类型属性
    @Test
    public void test3(){
        Person person3 = context.getBean("person3", Person.class);
        Person person4 = context.getBean("person4", Person.class);
        Person person5 = context.getBean("person5", Person.class);
        System.out.println(person3);
        System.out.println(person4);
        System.out.println(person5);
    }

    //注入List、Set、Map类型
    @Test
    public void test4(){
        Person person6 = context.getBean("person6", Person.class);
        System.out.println(person6);
    }

    //通过p名称空间注入属性
    @Test
    public void test5(){
        Person person7 = context.getBean("person7", Person.class);
        System.out.println(person7);
    }


    //bean的继承关系
    @Test
    public void test6(){
        Person person8 = context.getBean("person8", Person.class);
        System.out.println(person8);
        //不能实例化抽象bean，否则会抛异常
        //Person abstractPerson = context.getBean("abstractPerson", Person.class);
        Person person9 = context.getBean("person9", Person.class);
        System.out.println(person9);
    }

    //bean的依赖关系
    @Test
    public void test7(){
        Person person10 = context.getBean("person10", Person.class);
        System.out.println(person10);
    }


}

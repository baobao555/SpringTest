package com.baobao.springtest.di.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baobao
 * @create 2020-01-14 16:21
 * @description 测试引入外部配置文件
 */
public class ConfigfileTest {
    private ApplicationContext context;

    @Before
    public void initContext(){
        //初始化ioc容器
        context = new ClassPathXmlApplicationContext("applicationContext-configfile.xml");
    }

    @Test
    public void testConfigfile(){
        Object dataSource = context.getBean("dataSource");
        System.out.println(dataSource);
    }
}

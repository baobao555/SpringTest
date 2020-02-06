package com.baobao.springtest.di.test.annotation;

import com.baobao.springtest.di.annotation.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baobao
 * @create 2020-01-20 9:02
 * @description
 */
public class AnnotationTest {
    private ApplicationContext context;

    @Before
    public void initContext(){
        //初始化ioc容器
        context = new ClassPathXmlApplicationContext("annotation/applicationContext-annotation.xml");
    }

    @Test
    public void testComponentScan(){
        UserController userController = context.getBean("userController", UserController.class);
        userController.insert();
    }
}

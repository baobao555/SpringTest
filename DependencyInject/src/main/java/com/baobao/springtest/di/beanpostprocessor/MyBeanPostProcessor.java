package com.baobao.springtest.di.beanpostprocessor;

import com.baobao.springtest.di.bean.Address;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author baobao
 * @create 2020-01-15 9:25
 * @description bean初始化后置处理器
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 在bean的init-method方法执行之前被调用
     * @param bean  被实例化的bean
     * @param beanName 被实例化的bean的名称
     * @return 实例化后的bean
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeforeInitialization:" + bean + beanName);
        return bean;
    }

    /**
     * 在bean的init-method方法执行之后被调用
     * @param bean 被实例化的bean
     * @param beanName 被实例化的bean的名称
     * @return 实例化后的bean，即调用容器的getBean方法得到的bean对象
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AfterInitialization:" + bean + beanName);
        //可以偷梁换柱，改变getBean方法返回的bean
        return new Address("China", "ZheJiang" );
    }
}

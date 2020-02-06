package com.baobao.springtest.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author baobao
 * @create 2020-01-21 9:53
 * @description 校验切面类，演示切面优先级和环绕通知
 */

public class ValidateAspect {

    //环绕通知：类似于动态代理的invoke方法，可以控制方法执行的全过程，自由选择在相关位置
    //编写前置、后置、异常、返回通知的代码
    //需要传入ProceedingJoinPoint参数，控制方法执行时机
    public Object aroundNotify(ProceedingJoinPoint pjp){
        Object result = null;
        //得到切入的方法名
        String methodName = pjp.getSignature().getName();
        //得到切入方法的参数列表
        Object[] args = pjp.getArgs();
        try {
            //前置通知
            System.out.println("ValidateAspect前置通知：" + methodName + "执行了，参数是" + Arrays.asList(args));
            //方法执行
            result = pjp.proceed();
            //正常返回通知
            System.out.println("ValidateAspect正常返回通知：" + methodName + "返回值：" + result);
            //返回方法执行结果
            return result;
        } catch (Throwable throwable) {
            //异常通知
            System.out.println("ValidateAspect异常返回通知：" + methodName + "异常：" + throwable);
            throw new RuntimeException(throwable);
        }finally {
            //后置通知
            System.out.println("ValidateAspect后置通知：" + methodName + "执行了，参数是" + Arrays.asList(args));
        }
    }
}

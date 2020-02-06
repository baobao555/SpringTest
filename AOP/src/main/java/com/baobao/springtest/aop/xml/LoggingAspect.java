package com.baobao.springtest.aop.xml;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author baobao
 * @create 2020-01-20 10:59
 * @description 日志功能的切面类
 */

public class LoggingAspect {

    //前置通知：目标方法执行前调用
    public void beforeNotify(JoinPoint joinPoint){
        //得到切入的方法名
        String methodName = joinPoint.getSignature().getName();
        //得到切入方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggingAspect前置通知：" + methodName + "执行了，参数是" + Arrays.asList(args));
    }

    //后置通知：目标方法执行后调用(无论是否出异常都会执行，且因为有可能出异常，所以无法访问目标方法执行的返回值)
    public void afterNotify(JoinPoint joinPoint){
        //得到切入的方法名
        String methodName = joinPoint.getSignature().getName();
        //得到切入方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggingAspect后置通知：" + methodName + "执行了，参数是" + Arrays.asList(args));
    }

    //正常返回通知：目标方法正常返回后调用，可以访问到返回值
    public void afterReturningNotify(JoinPoint joinPoint,Object result){
        //得到切入的方法名
        String methodName = joinPoint.getSignature().getName();
        //得到切入方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggingAspect正常返回通知：" + methodName + "执行成功，参数是" + Arrays.asList(args) + "  result:" + result);
    }

    //异常返回通知：目标方法执行出异常时调用，可以访问到异常对象
    public void afterThrowingNotify(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggingAspect异常返回通知：" + methodName + "发生了异常，参数是" + Arrays.asList(args) + "  发生了异常：" + ex);
    }

    public Object aroundNotify(ProceedingJoinPoint pjp){
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        Object result = null;
        try {
            System.out.println("LoggingAspect环绕：前置通知");
            result = pjp.proceed();
            System.out.println("LoggingAspect环绕：正常返回通知，result：" + result);
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("LoggingAspect环绕：异常通知，异常：" + throwable);
            //一定要抛出异常，否则由于同个切面内环绕通知优先级高，如果自己抓住了异常会导致后续普通通知无法感知到异常
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("LoggingAspect环绕：后置通知");
        }
    }
}

package com.baobao.springtest.aop.annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author baobao
 * @create 2020-01-20 10:59
 * @description 日志功能的切面类
 */

@Order(2)  //切面优先级，数字越小优先级越高
@Component //将切面对象加入到ioc容器中
@Aspect   //声明为一个切面类
public class LoggingAspect {

    //定义切入点表达式的方法，方便后续重用
    @Pointcut("execution(* com.baobao.springtest.aop.annotation.CalculatorImpl.*(..))")
    public void pointCutExp(){
    }

    //前置通知：目标方法执行前调用
    @Before("pointCutExp()")
    public void beforeNotify(JoinPoint joinPoint){
        //得到切入的方法名
        String methodName = joinPoint.getSignature().getName();
        //得到切入方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggingAspect前置通知：" + methodName + "执行了，参数是" + Arrays.asList(args));
    }

    //后置通知：目标方法执行后调用(无论是否出异常都会执行，且因为有可能出异常，所以无法访问目标方法执行的返回值)
    @After("pointCutExp()")
    public void afterNotify(JoinPoint joinPoint){
        //得到切入的方法名
        String methodName = joinPoint.getSignature().getName();
        //得到切入方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggingAspect后置通知：" + methodName + "执行了，参数是" + Arrays.asList(args));
    }

    //正常返回通知：目标方法正常返回后调用，可以访问到返回值
    //value:切入点表达式   returning：指定返回值形参的名称
    @AfterReturning(value = "pointCutExp()",returning = "result")
    public void afterReturningNotify(JoinPoint joinPoint,Object result){
        //得到切入的方法名
        String methodName = joinPoint.getSignature().getName();
        //得到切入方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggingAspect正常返回通知：" + methodName + "执行成功，参数是" + Arrays.asList(args) + "  result:" + result);
    }

    //异常返回通知：目标方法执行出异常时调用，可以访问到异常对象
    //value:切入点表达式   throwing：指定异常对象形参的名称
    @AfterThrowing(value = "pointCutExp()",throwing = "ex")
    public void afterThrowingNotify(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggingAspect异常返回通知：" + methodName + "发生了异常，参数是" + Arrays.asList(args) + "  发生了异常：" + ex);
    }

}

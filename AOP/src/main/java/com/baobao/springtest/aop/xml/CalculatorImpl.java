package com.baobao.springtest.aop.xml;


/**
 * @author baobao
 * @create 2020-01-20 10:58
 * @description 计算器实现类，代表具体业务功能
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int sub(int x, int y) {
        return x - y;
    }

    @Override
    public int mul(int x, int y) {
        return x * y;
    }

    @Override
    public int div(int x, int y) {
        return x / y;
    }
}

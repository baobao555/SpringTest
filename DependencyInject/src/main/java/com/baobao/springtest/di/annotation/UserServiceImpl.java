package com.baobao.springtest.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author baobao
 * @create 2020-01-16 16:52
 * @description
 *
 * Service：表示将一个Service层的bean加入容器，默认id为类名首字母小写，如需自定义id，需要给注解的value属性赋值
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    //自动装配：将容器中对应类型的bean自动注入到该成员变量
    @Autowired
    private UserDao userDao;

    @Override
    public void insert() {
        System.out.println("UserServiceImpl insert");
        userDao.insert();
    }
}

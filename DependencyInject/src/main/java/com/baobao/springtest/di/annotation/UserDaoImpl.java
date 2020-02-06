package com.baobao.springtest.di.annotation;

import org.springframework.stereotype.Repository;

/**
 * @author baobao
 * @create 2020-01-16 16:50
 * @description
 *
 * Repository：表示将一个Dao层的bean加入容器，默认id为类名首字母小写，如需自定义id，需要给注解的value属性赋值
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void insert() {
        System.out.println("UserDaoImpl insert");
    }
}

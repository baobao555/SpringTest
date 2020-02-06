package com.baobao.springtest.transaction.service;

import com.baobao.springtest.transaction.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author baobao
 * @create 2020-01-29 15:20
 * @description
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    //通过@Transactional注解增加事务
    /*
    传播行为：Propagation propagation() default Propagation.REQUIRED;

    隔离级别：Isolation isolation() default Isolation.DEFAULT;

    超时，指定超过多少时间事务判定位失败并且回滚：int timeout() default -1;

    是否只读，只包含查询操作时配置可以提升效率：boolean readOnly() default false;

    设置哪些异常回滚：Class<? extends Throwable>[] rollbackFor() default {};

    设置哪些异常不回滚：Class<? extends Throwable>[] noRollbackFor() default {};*/
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyBook(String bookName,int bookNum,String account){
        //1、查询得到所买图书的单价
        Integer price = bookDao.getPrice(bookName);
        //2、计算总价
        int totalPrice = price * bookNum;
        //3、结账
        //3.1 图书库存 - bookNum
        bookDao.updateBookStore(bookName, bookNum);

        //出现异常
        //int i = 10 / 0;

        //3.2 对应账号 - 总价
        bookDao.updateAccount(account, totalPrice);
    }


    @Transactional(noRollbackFor = {NullPointerException.class},propagation = Propagation.REQUIRED)
    public void buyBook2(String bookName,int bookNum,String account){
        //1、查询得到所买图书的单价
        Integer price = bookDao.getPrice(bookName);
        //2、计算总价
        int totalPrice = price * bookNum;
        //3、结账
        //3.1 图书库存 - bookNum
        bookDao.updateBookStore(bookName, bookNum);

        //出现空指针异常
        String a = null;
        a.chars();

        //3.2 对应账号 - 总价
        bookDao.updateAccount(account, totalPrice);
    }

    /*
    * 传播行为：如果外层事务方法调用了另外一个内层事务方法，那么传播行为决定了内层事务方法是与外层方法共享事务还是自己新开一个事务
    *
    * Propagation.REQUIRES_NEW：不与外层方法共享事务，自己单独开启一个新事务
    * Propagation.REQUIRED：如果外层方法有事务，则与其共享，否则自己新开一个事务
    *
    * 假设：
    * @Transactional
    * T(){
    *   Propagation.REQUIRES_NEW
    *   A();
    *
    *   Propagation.REQUIRED
    *   B();
    * }
    *
    * 那么，A会新开一个事务，B与T方法共享一个事务。
    * 只要A能正常执行完，A的事务就成功了，后续发生任何异常回滚都不会影响A中已成功的操作
    *
    * 比喻：出去玩是坐别人已经准备开的车还是自己开新车
    *
    * 注：嵌套方法的时候，外层方法T与内层方法A、B必须是不同的Service类，如果外层和内层方法来自同个Service类，
    * 传播方式配置将不生效
    * */
}

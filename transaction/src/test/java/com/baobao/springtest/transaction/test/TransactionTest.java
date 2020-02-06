package com.baobao.springtest.transaction.test;

import com.baobao.springtest.transaction.service.BookService;
import com.baobao.springtest.transaction.service.MultiTransaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baobao
 * @create 2020-01-29 15:34
 * @description
 */
public class TransactionTest {
    @Test
    public void testTransaction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-transactionAnnotation.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        //bookService.buyBook("java", 1, "baobao");
        bookService.buyBook2("python",2,"ligong");
    }

    @Test
    public void testPropagation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-transactionAnnotation.xml");
        /*BookService bookService = context.getBean("bookService", BookService.class);
        bookService.multx();*/
        MultiTransaction multiTransaction = context.getBean("multiTransaction", MultiTransaction.class);
        multiTransaction.multx();
    }
}

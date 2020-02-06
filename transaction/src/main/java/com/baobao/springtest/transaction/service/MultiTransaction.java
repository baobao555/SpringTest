package com.baobao.springtest.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author baobao
 * @create 2020-01-29 17:14
 * @description
 */
@Service
public class MultiTransaction {
    @Autowired
    private BookService bookService;

    @Transactional
    public void multx(){
        bookService.buyBook("java", 1, "baobao");
        bookService.buyBook2("python", 2, "ligong");
    }
}

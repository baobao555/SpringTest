package com.baobao.springtest.transaction.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author baobao
 * @create 2020-01-29 12:13
 * @description
 */
public interface BookDao {
    //根据书名查询得到书的单价
    @Select("select price from book where name = #{bookName}")
    Integer getPrice(String bookName);

    //更新书的剩余库存
    //多个形参时要给每个形参配置参数名，否则#{num}无法识别
    @Update("update book_store set store = store - #{bookNum} where name = #{bookName}")
    void updateBookStore(@Param("bookName") String bookName, @Param("bookNum") Integer bookNum);

    //更新账户余额
    @Update("update account set money = money - #{value} where name = #{accountName}")
    void updateAccount(@Param("accountName") String accountName,@Param("value") Integer value);

}

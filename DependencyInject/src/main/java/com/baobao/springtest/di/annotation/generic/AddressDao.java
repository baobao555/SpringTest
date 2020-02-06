package com.baobao.springtest.di.annotation.generic;

import com.baobao.springtest.di.bean.Address;
import org.springframework.stereotype.Repository;

/**
 * @author baobao
 * @create 2020-01-20 9:36
 * @description 子类Dao
 */
@Repository//将子类Dao加入容器
public class AddressDao extends BaseDao<Address> {
}

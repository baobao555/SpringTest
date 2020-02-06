package com.baobao.springtest.di.annotation.generic;

import com.baobao.springtest.di.bean.Address;
import org.springframework.stereotype.Service;

/**
 * @author baobao
 * @create 2020-01-20 9:36
 * @description 子类Service
 */

@Service//将子类Service加入容器，获取时会自动将具体类型的子类Dao注入
public class AddressService extends BaseService<Address> {
}

package com.baobao.springtest.di.bean;

/**
 * @author baobao
 * @create 2020-01-13 16:42
 * @description
 */
public class Address {
    private String country;
    private String province;

    public void init(){
        System.out.println("Address init");
    }

    public void destroy(){
        System.out.println("Address destroy");
    }

    public Address(String country, String province) {
        this.country = country;
        this.province = province;
    }

    public Address() {
        System.out.println("Address无参构造函数");
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}

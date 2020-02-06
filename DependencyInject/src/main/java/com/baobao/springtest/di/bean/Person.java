package com.baobao.springtest.di.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author baobao
 * @create 2020-01-10 17:24
 * @description
 */
public class Person {
    private String name;
    private int age;
    private String job;
    private Address address;
    private List<Address> addList;
    private Set<String> addSet;
    private Map<String,Address> addMap;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Person() {
        System.out.println("Person无参构造函数");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<Address> getAddList() {
        return addList;
    }

    public void setAddList(List<Address> addList) {
        this.addList = addList;
    }

    public Set<String> getAddSet() {
        return addSet;
    }

    public void setAddSet(Set<String> addSet) {
        this.addSet = addSet;
    }

    public Map<String, Address> getAddMap() {
        return addMap;
    }

    public void setAddMap(Map<String, Address> addMap) {
        this.addMap = addMap;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address=" + address +
                ", addList=" + addList +
                ", addSet=" + addSet +
                ", addMap=" + addMap +
                '}';
    }
}

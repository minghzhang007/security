package com.lewis.security.dto;

/**
 * Created by Administrator on 2017/9/9.
 */
public class UserQueryCondtion {

    private String name;

    private int age;

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

    public UserQueryCondtion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserQueryCondtion() {
    }
}

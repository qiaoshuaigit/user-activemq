package com.shuai.model;

import java.io.Serializable;

/**
 * @author shuaion 2017/9/21
 **/
public class User implements Serializable{

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    private String name;

    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

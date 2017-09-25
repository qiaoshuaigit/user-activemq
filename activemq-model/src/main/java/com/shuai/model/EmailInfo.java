package com.shuai.model;

import java.io.Serializable;

/**
 * 发送邮件信息
 *
 * @author shuaion 2017/9/25
 **/
public class EmailInfo implements Serializable{

    private String acctountName;
    private String acctountPass;
    private String sendUrl;
    private String name;
    private String address;
    private String context;

    public String getAcctountName() {
        return acctountName;
    }

    public void setAcctountName(String acctountName) {
        this.acctountName = acctountName;
    }

    public String getAcctountPass() {
        return acctountPass;
    }

    public void setAcctountPass(String acctountPass) {
        this.acctountPass = acctountPass;
    }

    public String getSendUrl() {
        return sendUrl;
    }

    public void setSendUrl(String sendUrl) {
        this.sendUrl = sendUrl;
    }

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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "EmailInfo{" +
                "acctountName='" + acctountName + '\'' +
                ", acctountPass='" + acctountPass + '\'' +
                ", sendUrl='" + sendUrl + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}

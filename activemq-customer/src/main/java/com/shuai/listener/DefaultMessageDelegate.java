package com.shuai.listener;

import java.io.Serializable;
import java.util.Map;

/**
 * @author shuaion 2017/9/16
 **/
public class DefaultMessageDelegate implements MessageDelegate {

    public void handleMessage(String message) {
        if (message instanceof String) {
            System.out.println("String類型:" + message);
        } else {
            System.out.println("类型异常");
        }

    }

    public void handleMessage(Map message) {
        if (message instanceof Map) {
            System.out.println("Map类型:" + message);
        } else {
            System.out.println("类型异常");
        }
    }

    public void handleMessage(byte[] message) {
        if (message instanceof byte[]) {
            System.out.println("字節數組:" + message);
        } else {
            System.out.println("类型异常");
        }
    }

    public void handleMessage(Serializable message) {
        if (message instanceof Serializable) {
            System.out.println("Serializable類型:" + message);
        } else {
            System.out.println("类型异常");
        }
    }
}

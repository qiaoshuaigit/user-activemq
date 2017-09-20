package com.shuai.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听器
 *
 * @author shuaion 2017/9/16
 **/
public class ExampleListener implements MessageListener{

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                System.out.println("收到的消息是:"+((TextMessage) message).getText());
            }
            catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }
}

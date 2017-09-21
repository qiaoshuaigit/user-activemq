package com.shuai.listener;

import com.shuai.model.User;

import javax.jms.*;

/**
 * @author shuaion 2017/9/20
 **/
public class MessageTopicListener implements MessageListener {

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                System.out.println("topic 收到的消息是:"+((TextMessage) message).getText());
            }
            catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        }else if (message instanceof ObjectMessage){
            try {
                User user = (User) ((ObjectMessage) message).getObject();
                System.out.println("topic 收到的ObjectMessage消息是"+user.toString());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }
}

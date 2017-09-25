package com.shuai.service;

import com.shuai.model.EmailInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * 注册业务
 *
 * @author shuaion 2017/9/25
 **/
@Service
public class RegisterUserService {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private JmsTemplate jmsEmailTemplate;
    @Autowired
    private Destination emailDestination;

    public void register(){
        logger.info("注册业务开始");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("邮件加入消息队列开始.........");
        jmsEmailTemplate.send(emailDestination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage message = session.createObjectMessage();
                EmailInfo emailInfo = new EmailInfo();
                emailInfo.setName("张三");
                emailInfo.setAddress("北京");
                emailInfo.setAcctountName("zrmx-882344");
                emailInfo.setSendUrl("www.baidu.com");
                emailInfo.setAcctountPass("*************");
                message.setObject(emailInfo);
                return message;
            }
        });
        logger.info("邮件加入消息队列结束.........");

        logger.info("注册业务结束");
    }

}

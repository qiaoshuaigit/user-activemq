package com.shuai.service;

import com.shuai.model.EmailInfo;
import com.shuai.model.User;
import org.apache.log4j.Logger;

import javax.jms.*;

/**
 * 电子邮件发送业务
 *
 * @author shuaion 2017/9/25
 **/
public class EmailService implements MessageListener{

    private Logger logger = Logger.getLogger(this.getClass());

    public void onMessage(Message message){
        if (message instanceof ObjectMessage) {

            try {
                EmailInfo emailInfo = (EmailInfo)((ObjectMessage) message).getObject();

                logger.info("收到得邮件消息:"+emailInfo.toString());

                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
            logger.info("邮件消息发送完毕");
        }else {
            throw new IllegalArgumentException("email Service are not support Message type");
        }
    }
}

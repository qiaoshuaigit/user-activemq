package com.shuai.contro;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * @author shuaion 2017/9/14
 **/
@Controller
@RequestMapping("/provider")
public class UserProviderController {

    @Resource
    private JmsTemplate jmsTemplate;

    @Resource(name = "defaultDestination")
    private Destination defaultDestination;


    @RequestMapping("/send/{id}")
    @ResponseBody
    public void sendMessage(@PathVariable("id") final String id){
        System.out.println("----发送----"+id);
        jmsTemplate.send(defaultDestination,new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                //MapMessage mapMessage = session.createMapMessage();
                //mapMessage.setInt("typeofint",123456);
                return session.createTextMessage(id);
                //return mapMessage;
            }
        });
    }


}

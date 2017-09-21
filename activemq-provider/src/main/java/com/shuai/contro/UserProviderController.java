package com.shuai.contro;

import com.shuai.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Qualifier("jmsQueueTemplate")
    @Resource
    private JmsTemplate jmsTemplate;

    @Qualifier("jmsTopicTemplate")
    @Resource
    private JmsTemplate jmsTopicTemplate;

    @Resource(name = "defaultDestination")
    private Destination defaultDestination;

    @Resource(name = "topicDestination")
    private Destination topicDestination;


    @RequestMapping("/send/{id}")
    @ResponseBody
    public void sendMessage(@PathVariable("id") final String id) {
        System.out.println("----queue发送----" + id);
        jmsTemplate.send(defaultDestination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(id);
            }
        });
    }

    @RequestMapping("/sendTopic/{id}")
    @ResponseBody
    public void sendTopicMessage(@PathVariable("id") final String id) {
        System.out.println("topic发送" + id);
        jmsTopicTemplate.send(topicDestination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(id);
            }
        });
    }

    @RequestMapping("/sendModelTopic/")
    @ResponseBody
    public void sendTopicModelMessage() {
        jmsTopicTemplate.send(topicDestination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage message = session.createObjectMessage();
                User user = new User("特朗普","北京");
                message.setObject(user);
                System.out.println("topic发送model"+user.toString());
                return message;
            }
        });
    }

}

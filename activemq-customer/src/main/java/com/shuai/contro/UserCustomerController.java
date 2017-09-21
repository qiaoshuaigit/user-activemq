package com.shuai.contro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.MessageConsumer;

/**
 * 消费端
 *
 * @author shuaion 2017/9/15
 **/
@Controller
@RequestMapping("/customer")
public class UserCustomerController {

    private MessageConsumer customer;

    @RequestMapping("/getMessage")
    @ResponseBody
    public Object getMessage(){

        return null;
    }
}

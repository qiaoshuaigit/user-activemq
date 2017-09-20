package com.shuai.contro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 消费端
 *
 * @author shuaion 2017/9/15
 **/
@Controller
@RequestMapping("/customer")
public class UserCustomerController {


    @RequestMapping("/getMessage")
    @ResponseBody
    public Object getMessage(){

        return null;
    }
}

package com.shuai.contro;

import com.shuai.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 注册控制层
 *
 * @author shuaion 2017/9/25
 **/
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterUserService service;

    @RequestMapping("/user")
    @ResponseBody
    public Object registerUser(){
        long start = new Date().getTime();
        service.register();
        long end = new Date().getTime();
        return "register success! total="+(end-start)+"ms";
    }

}

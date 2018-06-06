package com.lyc.cloud.ip.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    SessionRepository sessionRepository;

    private static Integer count = 0;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "sss";
    }

    @GetMapping("/session")
    @ResponseBody
    public String getSession(){
        redisOperationsSessionRepository.
        return user;
    }


}

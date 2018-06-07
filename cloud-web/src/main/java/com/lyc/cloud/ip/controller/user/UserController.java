package com.lyc.cloud.ip.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "sss";
    }

    @GetMapping("/session")
    @ResponseBody
    public String getSession(HttpServletRequest request){
        String userName = (String)sessionStrategy.getAttribute(new ServletWebRequest(request),"userName");
        return userName;
    }
}

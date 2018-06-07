package com.lyc.cloud.ip.controller.user;

import com.lyc.cloud.ip.service.PublisherService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private PublisherService publisherService;


    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private SimpUserRegistry userRegistry;


    private static Integer count = 0;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "sss";
    }


    @GetMapping("/send")
    @ResponseBody
    public String sendMesg(){
        count++;
        template.convertAndSend("exchange","topic.message",count.toString());
        return count.toString();
    }

    @GetMapping("/pub")
    @ResponseBody
    public String pubMsg(){
        count++;
        publisherService.pubMsg(count.toString());
        return count.toString();
    }

}

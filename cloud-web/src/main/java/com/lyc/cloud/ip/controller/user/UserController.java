package com.lyc.cloud.ip.controller.user;

import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
    public Map<String,String> getSession(HttpServletRequest request){
        Map<String,String> map =new HashMap<>();
        String userName = (String)sessionStrategy.getAttribute(new ServletWebRequest(request),"userName");
        String image = (String)sessionStrategy.getAttribute(new ServletWebRequest(request),"image");
        map.put("userName",userName);
        map.put("image",image);
        return map;
    }
}

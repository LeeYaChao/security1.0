package com.lyc.cloud.ip.controller.user;

import com.lyc.cloud.ip.HelloMessage;
import com.lyc.cloud.ip.UserInfo;
import com.lyc.cloud.ip.security.core.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title:AppController.java</p>
 * <p>Description: </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2018</p>
 * <p>Date:2018年05月25</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Controller
public class AppController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private SimpUserRegistry userRegistry;


    @MessageMapping("/message")
    public void greeting(HelloMessage message) throws Exception {
        for (SimpUser user : userRegistry.getUsers()) {
            messagingTemplate.convertAndSendToUser(user.getName(), "/queue/reply", message);
        }
    }
}

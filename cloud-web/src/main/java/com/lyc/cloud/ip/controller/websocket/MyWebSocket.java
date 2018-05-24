/*
package com.lyc.cloud.ip.controller.websocket;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

*/
/**
 * <p>Title:MyWebSocket.java</p>
 * <p>Description: </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2018</p>
 * <p>Date:2018年05月24</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 *//*


@ServerEndpoint("/websocket")
@Component
public class MyWebSocket {

    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen (Session session){
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新链接加入!当前在线人数为" + getOnlineCount());
    }

    @OnClose
    public void onClose (){
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一链接关闭!当前在线人数为" + getOnlineCount());
    }

    @OnMessage
    @RabbitListener(queues="topic.message")
    public void onMessage (String message) throws IOException {
        System.out.println("来自客户端的消息:" + message);
        // 群发消息
        for ( MyWebSocket item : webSocketSet ){
            item.sendMessage(message);
        }
    }

    public void sendMessage (String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized  int getOnlineCount (){
        return MyWebSocket.onlineCount;
    }

    public static synchronized void addOnlineCount (){
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount (){
        MyWebSocket.onlineCount--;
    }

}
*/

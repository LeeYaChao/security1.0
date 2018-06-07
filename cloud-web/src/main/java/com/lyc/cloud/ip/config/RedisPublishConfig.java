/*
package com.lyc.cloud.ip.config;

import com.lyc.cloud.ip.controller.websocket.MyWebSocketRedis;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

*/
/**
 * <p>Title:RedisPublishConfig.java</p>
 * <p>Description: </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2018</p>
 * <p>Date:2018年05月24</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 *//*

@Configuration
public class RedisPublishConfig {
    */
/**
     * Redis的模板 作为发布者
     * @param connectionFactory
     * @return
     *//*

    @Bean
    public StringRedisTemplate template(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }

    */
/**
     * 创建连接工厂
     * @param connectionFactory
     * @param listenerAdapter
     * @return
     *//*

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter,new PatternTopic("phone"));
        return container;
    }

    */
/**
     * 绑定消息监听者和接收监听的方法
     * @param receiver
     * @return
     *//*

    @Bean
    public MessageListenerAdapter listenerAdapter(MyWebSocketRedis receiver){
        return new MessageListenerAdapter(receiver,"onMessage");
    }

}
*/

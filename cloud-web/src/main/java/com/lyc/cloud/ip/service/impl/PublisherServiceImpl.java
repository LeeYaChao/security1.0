package com.lyc.cloud.ip.service.impl;

import com.lyc.cloud.ip.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>Title:PublisherServiceImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: 公共服务与应急管理战略本部 Copyright(c)2018</p>
 * <p>Date:2018年05月24</p>
 *
 * @author 李亚超 (liyac@mail.taiji.com.cn)
 * @version 1.0
 */
@Service
public class PublisherServiceImpl implements PublisherService{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void pubMsg(String id) {
        stringRedisTemplate.convertAndSend("phone",id);
    }
}

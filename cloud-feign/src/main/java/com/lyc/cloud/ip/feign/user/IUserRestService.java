package com.lyc.cloud.ip.feign.user;

import com.lyc.cloud.ip.vo.UserInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "feign-interface-service-user")
public interface IUserRestService {

    @RequestMapping("/find-user-list")
    @ResponseBody
    public List<UserInfoVo> findAllList();
}

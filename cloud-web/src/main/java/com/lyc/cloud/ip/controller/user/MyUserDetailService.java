package com.lyc.cloud.ip.controller.user;

import com.lyc.cloud.ip.UserInfo;
import com.lyc.cloud.ip.security.core.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyUserDetailService implements UserDetailsService,SocialUserDetailsService{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoRepository userInfoRepository;


    /*@Autowired
    private PasswordEncoder passwordEncoder;*/
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private HttpServletRequest request;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		logger.info("表单登录用户名:" + username);
//		Admin admin = adminRepository.findByUsername(username);
//		admin.getUrls();
//		return admin;
        return buildUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("设计登录用户Id:" + userId);
        sessionStrategy.setAttribute(new ServletWebRequest(request),"userName",userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userId) {
        logger.info("登录名："+userId);
        UserInfo u = userInfoRepository.findByUserName(userId);
        if(null == u){
            u = userInfoRepository.findByMobile(userId);
        }
        String password = u.getPassword();
        sessionStrategy.setAttribute(new ServletWebRequest(request),"image",u.getImageUrl());
        return new SocialUser(userId,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

}


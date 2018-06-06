package com.lyc.cloud.ip.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyc.cloud.ip.security.core.properties.LoginType;
import com.lyc.cloud.ip.security.core.properties.SecurityConstants;
import com.lyc.cloud.ip.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component("lycAuthenticationSuccessHandler")
public class LycAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;//DEFAULT_INDEX_HTML

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        logger.info("登陆成功");
        redirectStrategy.sendRedirect(request,response, SecurityConstants.DEFAULT_INDEX_HTML);

    }
}

package com.lyc.cloud.ip.security.browser;

import com.lyc.cloud.ip.security.core.authentication.FormAuthenticationConfig;
import com.lyc.cloud.ip.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.lyc.cloud.ip.security.core.authorize.AuthorizeConfigManager;
import com.lyc.cloud.ip.security.core.properties.SecurityProperties;
import com.lyc.cloud.ip.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private SecurityProperties securityProperties;


    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private FormAuthenticationConfig formAuthenticationConfig;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private SpringSocialConfigurer lycSpringSocialConfigurer;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       formAuthenticationConfig.configure(http);
       http.apply(validateCodeSecurityConfig)
               .and()
           .apply(smsCodeAuthenticationSecurityConfig)
               .and()
           .apply(lycSpringSocialConfigurer)
               .and()
           .rememberMe()
               .tokenRepository(persistentTokenRepository())
               .tokenValiditySeconds(securityProperties.getBrowser().getRemeberMeSeconds())
               .userDetailsService(userDetailsService)
           .and()
           .csrf().disable();

        authorizeConfigManager.config(http.authorizeRequests());
    }
}

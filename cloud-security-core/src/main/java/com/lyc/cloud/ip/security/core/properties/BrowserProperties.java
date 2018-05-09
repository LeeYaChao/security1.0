package com.lyc.cloud.ip.security.core.properties;

import lombok.Data;

@Data
public class BrowserProperties {

    /**
     * 登录页面，当引发登录行为的url以html结尾时，会跳到这里配置的url上
     */
    private String signInPage = SecurityConstants.DEFAULT_SIGN_IN_PAGE_URL;

    private LoginType loginType = LoginType.JSON;

    private int remeberMeSeconds = 3600;

    /**
     * 登录成功后跳转的地址，如果设置了此属性，则登录成功后总是会跳到这个地址上。
     *
     * 只在loginType为REDIRECT时生效
     */
    private String singInSuccessUrl;

}

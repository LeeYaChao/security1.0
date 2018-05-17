/**
 * 
 */
package com.lyc.cloud.ip.security.core.properties;

import lombok.Data;

/**
 * 社交登录配置项
 * @author zhailiang
 *
 */
@Data
public class SocialProperties {
	
	/**
	 * 社交登录功能拦截的url
	 */
	private String filterProcessesUrl = "/qqLogin";

	private QQProperties qq = new QQProperties();
	
	private WeixinProperties weixin = new WeixinProperties();

}

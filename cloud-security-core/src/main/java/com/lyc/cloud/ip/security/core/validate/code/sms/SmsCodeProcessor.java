/**
 * 
 */
package com.lyc.cloud.ip.security.core.validate.code.sms;

import com.lyc.cloud.ip.security.core.properties.SecurityConstants;
import com.lyc.cloud.ip.security.core.validate.code.ValidateCode;
import com.lyc.cloud.ip.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * 短信验证码处理器
 * 
 * @author zhailiang
 *
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

	/**
	 * 短信验证码发送器
	 */
	@Autowired
	private SmsCodeSender smsCodeSender;
	
	@Override
	protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
		String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
		String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
		smsCodeSender.send(mobile, validateCode.getCode());
		HttpServletResponse response = request.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		JSONObject json = new JSONObject();
		json.put("mobile",mobile);
		json.put("valiCode",validateCode.getCode());
		PrintWriter out = null;
		out = response.getWriter();
		out.append(json.toString());
	}

}

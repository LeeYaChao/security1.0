package com.lyc.cloud.ip.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {

    ValidateCode generator(ServletWebRequest request);
}

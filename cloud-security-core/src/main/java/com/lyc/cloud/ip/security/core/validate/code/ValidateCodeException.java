package com.lyc.cloud.ip.security.core.validate.code;

public class ValidateCodeException extends org.springframework.security.core.AuthenticationException{


    public ValidateCodeException(String msg) {
        super(msg);
    }
}

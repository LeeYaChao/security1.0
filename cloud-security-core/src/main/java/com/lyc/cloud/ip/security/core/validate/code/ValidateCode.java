package com.lyc.cloud.ip.security.core.validate.code;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ValidateCode implements Serializable{

    public ValidateCode(){}

    public ValidateCode(String code, int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    private String code;

    private LocalDateTime expireTime;

    public boolean isExpired(){
       return LocalDateTime.now().isAfter(expireTime);
    }
}

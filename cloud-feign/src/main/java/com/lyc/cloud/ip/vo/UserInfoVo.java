package com.lyc.cloud.ip.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoVo {

    private Integer id;

    private String userName;

    private String password;

    private String name;

    private Integer age;

    private Integer sex;

    private Date birthday;

    private Date created;

    private Date updated;
}

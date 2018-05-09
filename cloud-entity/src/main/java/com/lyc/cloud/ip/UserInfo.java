package com.lyc.cloud.ip;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "T_USER")
public class UserInfo{

    @Id
    @GeneratedValue
    private Integer id;

    private String userName;

    private String password;

    private String name;

    private Integer age;

    private Integer sex;

    private String mobile;

    private Date birthday;

    private Date created;

    private Date updated;
}

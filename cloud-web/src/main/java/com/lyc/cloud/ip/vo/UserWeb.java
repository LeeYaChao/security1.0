package com.lyc.cloud.ip.vo;

import java.security.Principal;

public final class UserWeb implements Principal {

    private final String name;

    public UserWeb(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

package com.karl.apacheshiro.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Description TODO
 * @Date 2020/4/19 11:03
 * @Created karl xie
 */
public class ShiroAuthToken implements AuthenticationToken {
    private String token;
    public ShiroAuthToken(String token) { this.token = token; }

    @Override
    public Object getPrincipal() { return token;  }

    @Override
    public Object getCredentials() { return token; }
}

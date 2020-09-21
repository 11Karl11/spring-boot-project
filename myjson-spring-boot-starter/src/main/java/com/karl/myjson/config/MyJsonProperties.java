package com.karl.myjson.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author karl xie
 * Created on 2020-04-02 19:09
 */
@ConfigurationProperties(prefix = "ziyou.json")
public class MyJsonProperties {


    private String name = "ziyou";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
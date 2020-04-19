package com.karl.springlecture.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Description TODO
 * @Date 2020/4/17 23:28
 * @Created karl xie
 */
@Data
public class MyConfigBean {

    @Value("${myConfig.myObject.myName}")
    private String myName;

    @Value("${myConfig.myObject.myAge}")
    private int myAge;
}

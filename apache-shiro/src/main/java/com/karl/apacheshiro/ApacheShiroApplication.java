package com.karl.apacheshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.karl.apacheshiro.mapper")
@SpringBootApplication
public class ApacheShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApacheShiroApplication.class, args);
    }

}

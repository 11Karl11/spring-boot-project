package com.karl.springlecture.controller;

import com.karl.springlecture.config.MyConfigBean;
import com.karl.springlecture.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Date 2020/4/17 23:20
 * @Created karl xie
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${myConfig.myObject.myName}")
    private String myName;

    @Value("${myConfig.myObject.myAge}")
    private int myAge;

    @Autowired
    private MyConfigBean myConfigBean;

    @GetMapping("person")
    public Person getPerson() {
        return Person.builder().age(myAge).name(myName).id(11).build();
    }
    @GetMapping("person1")
    public Person getPerson1() {
        return Person.builder()
                .age(myConfigBean.getMyAge())
                .name(myConfigBean.getMyName())
                .build();
    }
}

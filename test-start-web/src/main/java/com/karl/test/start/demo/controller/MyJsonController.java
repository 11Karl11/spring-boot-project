package com.karl.test.start.demo.controller;

import com.karl.myjson.service.MyJsonService;
import com.karl.test.start.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author karl xie
 * Created on 2020-04-02 19:17
 */
@RestController
public class MyJsonController {

    @Autowired
    private MyJsonService myJsonService;

    @RequestMapping(value = "tojson")
    public String getStr() {
        User user = new User();
        user.setName("dsfsf");
        user.setAge(18);
        return myJsonService.objToJson(user);
    }
}
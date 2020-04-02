package com.karl.myjson.service;

import com.alibaba.fastjson.JSON;

/**
 * @author karl xie
 * Created on 2020-04-02 19:09
 */
public class MyJsonService {

    private String name;

    /**
     * 使用 fastjson 将对象转换为 json 字符串输出
     *
     * @param object 传入的对象
     * @return 输出的字符串
     */
    public String objToJson(Object object) {
        return getName() + JSON.toJSONString(object);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
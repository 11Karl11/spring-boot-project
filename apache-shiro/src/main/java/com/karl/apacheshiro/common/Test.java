package com.karl.apacheshiro.common;

/**
 * @author karl xie
 * Created on 2020-04-20 14:54
 */
public class Test {
    public static void main(String[] args) {
        String a="===2020-4-7 0:00:00===";
        String[] split = a.split("===");
        System.out.println(split);
        String s = split[1];
        String[] s1 = s.split(" ");
        String yyyyMMdd = s1[0];
        String HHmmss = s1[1];
        String[] ymd = yyyyMMdd.split("-");
        String[] hms = HHmmss.split(":");
        System.out.println("-------------------");

    }
}
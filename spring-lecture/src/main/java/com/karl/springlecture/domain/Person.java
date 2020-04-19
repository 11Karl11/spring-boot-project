package com.karl.springlecture.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @Description TODO
 * @Date 2020/4/17 23:21
 * @Created karl xie
 */
@Data
@Builder
public class Person {
    private Integer id;

    private String name;

    private Integer age;
}

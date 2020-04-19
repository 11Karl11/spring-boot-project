package com.karl.springlecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * JDWP: java Debug Write Protocol
 */
public class SpringLectureApplication {
    public static void main(String[] args) {
        System.out.println(SpringLectureApplication.class.getClassLoader());
        SpringApplication.run(SpringLectureApplication.class, args);
    }

}
